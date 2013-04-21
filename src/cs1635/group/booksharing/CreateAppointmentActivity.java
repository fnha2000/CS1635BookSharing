package cs1635.group.booksharing;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class CreateAppointmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_appointment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_appointment, menu);
		return true;
	}
	
	// Called on "Create appointment" button click.
	// This feature is currently non-functional.
	public void createAppointment(View view) {
		// Display confirmation dialog and return to home screen.
		DialogFragment dialog = new CreateAppointmentConfirmationDialogFragment();
		dialog.show(getSupportFragmentManager(), "CreateAppointmentConfirmationDialogFragment");
	}
}
