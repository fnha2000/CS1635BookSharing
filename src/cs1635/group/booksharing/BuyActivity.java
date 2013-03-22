package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class BuyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy, menu);
		return true;
	}
	
	// Called on Buy button press
	public void goToButton(View view) {
		Intent intent = new Intent(this, BuyBookDetailsActivity.class);
		startActivity(intent);
	}

}
