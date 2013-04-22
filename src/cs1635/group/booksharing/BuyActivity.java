package cs1635.group.booksharing;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BuyActivity extends ListActivity implements OnEditorActionListener {
	Context thisContext = null;
	BookAdapter adapter;
	BookDBSource bookSrc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		thisContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		
		bookSrc = new BookDBSource(this);
		EditText searchField = (EditText) findViewById(R.id.search_field);
		Button searchButton = (Button) findViewById(R.id.search_button);
		
		// This is for displaying dummy search results. We can replace it later with either a database query or
				// data pulled from a text file. It only displays the title for now, because I haven't figured out how
				// to set up list items with more than one line. This might actually be easier to do with a cursor.
				BookData[] dummyResultsArray = new BookData[0];
				adapter = new BookAdapter(this, android.R.layout.simple_list_item_1, dummyResultsArray);
				
				// Display search results
				searchField.setOnEditorActionListener(this);	
				searchButton.setOnEditorActionListener(this);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		bookSrc.open();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		bookSrc.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy, menu);
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

	// Called on Home button press
	public void goHome(View view) {
		finish();
	}
	
	public boolean goSearch(View view) {
		//need to implement this
		boolean handled = false;
		ListView listView = (ListView) findViewById(android.R.id.list);
		
		EditText queryText = (EditText)findViewById(R.id.search_field);
		List<BookData> bookList = bookSrc.queryBooks(queryText.getText().toString());
		BookData[] books = (BookData[])bookList.toArray(new BookData[bookList.size()]);
		adapter.clear();
		adapter.addBooks(books);
		listView.setAdapter(adapter);
		
		// Hide the keyboard
		InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		handled = true;
			
		return handled;
	}
	
	// Called on Buy button press
	// This is just a hardcoded dummy method to go to the details for the sample book.
	// We need to figure out how to go to the selected book for real data.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, BuyBookDetailsActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		ListView listView = (ListView) findViewById(android.R.id.list);
		boolean handled = false;

		EditText queryText = (EditText)findViewById(R.id.search_field);
		List<BookData> bookList = bookSrc.queryBooks(queryText.getText().toString());
		BookData[] books = (BookData[])bookList.toArray(new BookData[bookList.size()]);
		adapter.clear();
		adapter.addBooks(books);
		listView.setAdapter(adapter);
		
		// Hide the keyboard
		InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		handled = true;
		
		return handled;
	}
}
