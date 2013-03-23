package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class SellActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sell, menu);
		return true;
	}
	
	// Called on Add Book button press.
	public void goToAddBook(View view) {
		Intent intent = new Intent(this, AddBookActivity.class);
		startActivity(intent);
	}
	
	// Called on Edit button press.
	// NOTE: Once we implement the underlying systems, we'll probably want to change this to go to its own activity that lets the user edit the existing information,
	// but for now, I'm just linking it to the screen to add a new book.
	public void edit(View view) {
		Intent intent = new Intent(this, AddBookActivity.class);
		startActivity(intent);
	}

}
