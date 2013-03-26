package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class AddBookActivity extends Activity {

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
	
	// Called when Back button is pressed
	public void goBack(View view) {
		Intent intent = new Intent(this, SellActivity.class);
		startActivity(intent);
	}
	
	// Called when Home button is pressed
	public void goHome(View view) {
		// Add code here.
	}
	
	// Called when Post button is pressed
	public void post(View view) {
		Intent intent = new Intent(this, ConfirmPostActivity.class);
		startActivity(intent);
	}
	
	// Called when Add Photo button is pressed
	public void addPhoto(View view) {
		// Add code here.
	}

}
