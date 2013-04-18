package cs1635.group.booksharing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AppointmentDetailsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_details);
		Intent intent = getIntent();
		TextView locView = (TextView)findViewById(R.id.appointment_address);
		TextView dateView = (TextView)findViewById(R.id.appointment_date);
		TextView timeView = (TextView)findViewById(R.id.appointment_time);
		TextView msgView = (TextView)findViewById(R.id.appointment_message);
		locView.setText(intent.getStringExtra("Location"));
		dateView.setText(intent.getStringExtra("Date"));
		timeView.setText(intent.getStringExtra("Time"));
		msgView.setText(intent.getStringExtra("Message"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_details, menu);
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
	
	// Called on "View map" button click.
	// Currently non-functional. Should launch map displaying appointment location.
	public void viewMap(View view) {
		
	}
	
	// Called on "Cancel appointment" button click.
	// This obviously doesn't affect any data at the moment.
	public void cancel(View view) {
		// Display confirmation dialog
		DialogFragment dialog = new ConfirmCancelAppointmentDialogFragment();
		dialog.show(getSupportFragmentManager(), "ConfirmCancelAppointmentDialogFragment");
	}
	
	public void goBack(View v) {
		finish();
	}
	
	public void goMessage(View v) {
		Intent intent = new Intent(this, BuyMessageActivity.class);
		startActivity(intent);
	}
	
	// Called on "Call user" button click. Places phone call to user.
	public void callUser(View v) {
		String phoneNumber = "555-555-5555";	// Hardcoded dummy phone number
		String uri = "tel:" + phoneNumber;
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
		startActivity(intent);
	}

}
