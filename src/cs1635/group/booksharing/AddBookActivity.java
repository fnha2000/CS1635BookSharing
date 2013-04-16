package cs1635.group.booksharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AddBookActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_book);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_book, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	    	Intent intent = new Intent();
			intent.putExtra("action", "None");
			setResult(0, intent);
			finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	// Called when "Home" button is pressed
	public void goHome(View view) {
		Intent intent = new Intent();
		intent.putExtra("action", "Home");
		setResult(0, intent);
		finish();
	}
	
	// Called when "Post" button is pressed
	public void post(View view) {
		DialogFragment dialog = new ConfirmPostDialogFragment();
		dialog.show(getSupportFragmentManager(), "ConfirmPostDialogFragment");
	}
	
	// Called when "Add photo" button is pressed
	public void addPhoto(View view) {
		// Add code here.
	}
	
	// Called when "Scan barcode"
	public void scan(View view) {
		// Add code here.
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent();
			intent.putExtra("action", "None");
			setResult(0, intent);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
