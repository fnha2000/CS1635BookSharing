package cs1635.group.booksharing;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BuyActivity extends ListActivity {
	Context thisContext = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		thisContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);

		EditText searchField = (EditText) findViewById(R.id.search_field);
		
		// This is for displaying dummy search results. We can replace it later with either a database query or
				// data pulled from a text file. It only displays the title for now, because I haven't figured out how
				// to set up list items with more than one line. This might actually be easier to do with a cursor.
				String[] dummyResultsArray = {"Programming Android", "Programming Android", "Programming Android", "Programming Android", "Programming Android"}; 
				final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummyResultsArray);
				final ListView listView = (ListView) findViewById(android.R.id.list);
				
				// Display search results
				searchField.setOnEditorActionListener(new OnEditorActionListener() {
		        	@Override
		        	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		        		boolean handled = false;
		       
		        		// Populate the list with four instances of dummy data.
		        		listView.setAdapter(adapter);
		        		
		        		return handled;
		        	}
		        });		
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
	
	// Called on Buy button press
	public void goToButton(View view) {
		Intent intent = new Intent(this, BuyBookDetailsActivity.class);
		startActivity(intent);
	}

	// Called on Home button press
	public void goHome(View view) {
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}
	
	// Called on Buy button press
	// This is just a hardcoded dummy method to go to the details for the sample book.
	// We need to figure out how to go to the selected book for real data.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, BuyBookDetailsActivity.class);
		startActivity(intent);
	}
	
}
