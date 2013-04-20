package cs1635.group.booksharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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
		// TODO: Add code here.
	}
	
	// Called when "Scan barcode" button is clicked
	public void scan(View view) {
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}
	
	// Handles result of barcode scan
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null) {
			// TODO: Handle scan result
		}
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
