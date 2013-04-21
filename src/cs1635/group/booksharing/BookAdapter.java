package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<BookData> {
	private final Context context;
	private BookData[] books;
	
	public BookAdapter(Context context, int layoutResourceId, BookData[] books) {
		super(context, R.layout.book_list_layout, books);
		this.context = context;
		this.books = books;
	}
	
	@Override
	public int getCount() {
		return books != null ? books.length : 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) ((Activity)context).getLayoutInflater();
		View listView = inflater.inflate(R.layout.book_list_layout, parent, false);
		
		TextView title = (TextView)listView.findViewById(R.id.title);
		TextView price = (TextView)listView.findViewById(R.id.price);
		
		BookData currentMessage = books[position];
		title.setText(currentMessage.title);
		price.setText(currentMessage.price);
		
		return listView;
	}

	public void addBooks(BookData[] books) {
		this.books = books;
	}
}
