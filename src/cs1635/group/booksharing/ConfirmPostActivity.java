package cs1635.group.booksharing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ConfirmPostActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_post);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_confirm_post, menu);
		return true;
	}
	
	// Called when Return to Home Screen button is pressed.
	public void goHome(View view) {
		// Add code here.
	}

}
