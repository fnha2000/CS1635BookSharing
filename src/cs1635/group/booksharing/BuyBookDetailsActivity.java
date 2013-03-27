package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BuyBookDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_book_details);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);	// API level is too high.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy_book_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Called on Back button click
	public void goBack(View view) {
		Intent intent = new Intent(this, BuyActivity.class);
		startActivity(intent);
	}
	
	// Called on Home button click
	public void goHome(View view) {
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}
	
	// Called on Buy button click
	public void goToBuy(View view) {
		Intent intent = new Intent(this, BuyMessageActivity.class);
		startActivity(intent);
	}
	

}
