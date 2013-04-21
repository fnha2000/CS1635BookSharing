package cs1635.group.booksharing;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class SellActivity extends ListActivity {
	BookAdapter adapter;
	BookDBSource bookSrc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		
		bookSrc = new BookDBSource(this);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		bookSrc.open();
		List<BookData> bookList = bookSrc.getMyBooks(Home.currentUser);
		BookData[] books = (BookData[])bookList.toArray(new BookData[bookList.size()]);
		
		adapter = new BookAdapter(this, android.R.layout.simple_list_item_1, books);
		ListView listView = (ListView) findViewById(android.R.id.list);
		
		listView.setAdapter(adapter);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		bookSrc.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sell, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String action = data.getStringExtra("action");
		if (action.equals("Home")) {
			finish();
		}
	}
	
	// Called on Add Book button press.
	public void goToAddBook(View view) {
		Intent intent = new Intent(this, AddBookActivity.class);
		startActivityForResult(intent, 0);
	}
	
	// Called on Buy button press
	// This is just a hardcoded dummy method to go to the details for the sample book.
	// We need to figure out how to go to the selected book for real data.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, AddBookActivity.class);
		startActivity(intent);
	}

	public void goHome(View v) {
		finish();
	}
}
