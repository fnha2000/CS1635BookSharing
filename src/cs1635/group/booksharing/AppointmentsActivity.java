package cs1635.group.booksharing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class AppointmentsActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		
		AppointmentData[] apt = new AppointmentData[2];
		apt[0] = new AppointmentData("John Smith", "01/01/13", "00:00", "Hillman");
		apt[1] = new AppointmentData("John Smith", "01/01/13", "00:02", "Starbucks");
		AppointmentAdapter apts = new AppointmentAdapter(this, R.layout.appointment_layout, apt);
		setListAdapter(apts);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_appointments, menu);
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
	
	// Called on list item click. Opens hardcoded sample appointment.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, AppointmentDetailsActivity.class);
		startActivity(intent);
	}
	
	// Called on Home button press
	public void goHome(View view) {
		finish();
	}
}
