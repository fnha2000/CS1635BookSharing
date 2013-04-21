package cs1635.group.booksharing;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BookDBSource {
	private SQLiteDatabase db;
	private BookDBHelper dbHelper;
	private String[] allColumns = {BookDBHelper.COLUMN_ID, BookDBHelper.COLUMN_ISBN, 
			BookDBHelper.COLUMN_TITLE, BookDBHelper.COLUMN_AUTHOR, BookDBHelper.COLUMN_SUBJECT, 
			BookDBHelper.COLUMN_PRICE, BookDBHelper.COLUMN_SELLER};
	private String[] ftsColumns = {BookDBHelper.COLUMN_ISBN, 
			BookDBHelper.COLUMN_TITLE, BookDBHelper.COLUMN_AUTHOR, BookDBHelper.COLUMN_SUBJECT};
	
	public BookDBSource(Context context) {
		dbHelper = new BookDBHelper(context);
	}
	
	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public BookData addBook(String isbn, String title, String author, String subject, String price, String seller) {
		ContentValues values = new ContentValues();
		values.put(BookDBHelper.COLUMN_ISBN, isbn);
		values.put(BookDBHelper.COLUMN_TITLE, title);
		values.put(BookDBHelper.COLUMN_AUTHOR, author);
		values.put(BookDBHelper.COLUMN_SUBJECT, subject);
		values.put(BookDBHelper.COLUMN_PRICE, price);
		values.put(BookDBHelper.COLUMN_SELLER, seller);
		long insertID = db.insert(BookDBHelper.TABLE_BOOKS, null, values);
		db.insert(BookDBHelper.TABLE_BOOKS_FTS, null, values);
		Cursor cursor = db.query(BookDBHelper.TABLE_BOOKS, allColumns, BookDBHelper.COLUMN_ID + " = ?",
				new String[] {Long.toString(insertID)}, null, null, null);
		cursor.moveToFirst();
		BookData newBook = cursorToBook(cursor);
		cursor.close();
		return newBook;
	}
	
	public void deleteBook(BookData book) {
		long id = book.id;
		db.delete(BookDBHelper.TABLE_BOOKS, BookDBHelper.COLUMN_ID + " = ?", new String[] {Long.toString(id)});
		db.delete(BookDBHelper.TABLE_BOOKS_FTS, BookDBHelper.COLUMN_ID + " = ?", new String[] {Long.toString(id)});
	}
	
	public List<BookData> getMyBooks(String username) {
		List<BookData> books = new ArrayList<BookData>();
		Cursor cursor = db.query(BookDBHelper.TABLE_BOOKS_FTS, allColumns, BookDBHelper.COLUMN_SELLER + " = ?",
				new String[] {username}, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			BookData data = cursorToBook(cursor);
			books.add(data);
			cursor.moveToNext();
		}
		cursor.close();
		return books;
	}
	
	public List<BookData> queryBooks(String query) {
		List<BookData> books = new ArrayList<BookData>();
		Cursor cursor = db.query(BookDBHelper.TABLE_BOOKS_FTS, allColumns,
				BookDBHelper.TABLE_BOOKS_FTS + " MATCH ?",
				new String[] {query}, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			BookData data = cursorToBook(cursor);
			books.add(data);
			cursor.moveToNext();
		}
		cursor.close();
		return books;
	}
	
	private BookData cursorToBook(Cursor cursor) {
		BookData book = new BookData(cursor.getLong(0), cursor.getString(1), cursor.getString(2),
				cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
		return book;
	}
}
