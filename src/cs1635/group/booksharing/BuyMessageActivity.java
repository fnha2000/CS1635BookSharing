package cs1635.group.booksharing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BuyMessageActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_message);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);	// API level is too high.
		
		// Hide keyboard when user is done.
		EditText editText = (EditText)findViewById(R.id.editText1);
		editText.setOnEditorActionListener(new OnEditorActionListener() {
	    	@Override
	    	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	    		boolean handled = false;
				
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					handled = true;
					
	    			// Close keyboard
	    			InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	    		}
	    		
	    		return handled;
	    	}
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy_message, menu);
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
	
	// Called on Back button click
	public void goBack(View view) {
		finish();
	}
	
	// Called on Home button click
	public void goHome(View view) {
		finish();
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}
	
	// Called on Send button click
	public void goToSendConfirmation(View view) {
		DialogFragment dialog = new SendConfirmationDialogFragment();
		dialog.show(getSupportFragmentManager(), "SendConfirmationDialogFragment");
	}

}
