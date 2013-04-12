package cs1635.group.booksharing;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class AppointmentDetailsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_details);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_details, menu);
		return true;
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

}
