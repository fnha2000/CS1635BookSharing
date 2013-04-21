/* Parses XML file returned by ISBNDB.com and extracts title, author(s), and first subject listed.
 * Based on the Android tutorial at http://developer.android.com/training/basics/network-ops/xml.html
 * 
 * NOTE: This class uses its own BookData class, which is also used by AddBookActivity.java. We might be able
 * to combine this with the BookData class defined in BookData.java to simplify things.
 */

package cs1635.group.booksharing;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class BookDataXmlParser {
	// Don't use namespaces
	private static final String ns = null;
	
	// Holds data for book
	public static class BookData {
		public final String title;
		public final String author;
		public final String subject;
		
		private BookData(String title, String author, String subject) {
			this.title = title;
			this.author = author;
			this.subject = subject;
		}
		
		// toString() method for debugging.
		@Override
		public String toString() {
			return "Title: " + title + "\nAuthor(s): " + author + "\nSubject: " + subject;
		}
	}
	
	public BookData parse(InputStream in) throws XmlPullParserException, IOException {
		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in, null);
			parser.nextTag();
			return readData(parser);
		} finally {
			in.close();
		}
	}
	
	// Processes XML
	private BookData readData(XmlPullParser parser) throws XmlPullParserException, IOException {
		BookData bookData = null;
		
		parser.require(XmlPullParser.START_TAG, ns, "ISBNdb");

		while (parser.next() != XmlPullParser.END_TAG && bookData == null) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();

			// Starts by looking for the BookData tag
			if (name.equals("BookList")) {
				bookData = readBookList(parser);
			} else {
				skip(parser);
			}
		}
		
		return bookData;
	}
	
	// Processes BookList tag
	private BookData readBookList(XmlPullParser parser) throws XmlPullParserException, IOException {
		BookData bookData = null;
		
		parser.require(XmlPullParser.START_TAG, ns, "BookList");
		
		while (parser.next() != XmlPullParser.END_TAG && bookData == null) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			
			// Starts by looking for the BookData tag
			if (name.equals("BookData")) {
				bookData = readBookData(parser);
			} else {
				skip(parser);
			}
		}
		
		return bookData;
	}
	
	
	
	// Parses the contents of a BookData tag
	private BookData readBookData(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, ns, "BookData");
		
		String title = null;
		String author = null;
		String subject = null;
		
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			
			String name = parser.getName();
			if (name.equals("Title")) {
				title = readTitle(parser);
			} else if (name.equals("AuthorsText")) {
				author = readAuthor(parser);
			} else if (name.equals("Subjects")) {
				subject = readSubjectsList(parser);
			} else {
				skip(parser);
			}
		}
		
		return new BookData(title, author, subject);
	}
	
	// Processes Title tags
	private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, ns, "Title");
		String title = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "Title");
		return title;
	}
	
	// Processes AuthorsText tags
	private String readAuthor(XmlPullParser parser) throws IOException, XmlPullParserException {	
		parser.require(XmlPullParser.START_TAG, ns, "AuthorsText");
		String author = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "AuthorsText");
		return author;
	}
	
	// Parses the contents of a Subjects tag
	private String readSubjectsList(XmlPullParser parser) throws XmlPullParserException, IOException {	
		parser.require(XmlPullParser.START_TAG, ns, "Subjects");
		
		String subject = null;
		
		while (parser.next() != XmlPullParser.END_TAG && subject == null) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			
			String name = parser.getName();
			if (name.equals("Subject")) {
				subject = readSubject(parser);
			} else {
				skip(parser);
			}
		}
		
		return subject;
	}
	
	// Processes Subject tags
	private String readSubject(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, ns, "Subject");
		String subject = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "Subject");
		return subject;
	}
	
	// Extracts text
	private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {		
		String result = "";
		if (parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			System.out.println("Text read: " + result);
			parser.nextTag();
		}
		return result;
	}
	
	// Skips a tag
	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {		
		if (parser.getEventType() != XmlPullParser.START_TAG) {
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth != 0) {
			switch (parser.next()) {
			case XmlPullParser.END_TAG:
				depth--;
				break;
			case XmlPullParser.START_TAG:
				depth++;
				break;
			}
		}
	}
}
