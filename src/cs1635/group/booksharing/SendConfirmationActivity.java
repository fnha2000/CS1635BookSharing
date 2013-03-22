package cs1635.group.booksharing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class SendConfirmationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_confirmation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_send_confirmation, menu);
		return true;
	}
	
	// Called on Return to Home Screen button click
	public void goHome(View view) {
		// Add code here.
	}

}
