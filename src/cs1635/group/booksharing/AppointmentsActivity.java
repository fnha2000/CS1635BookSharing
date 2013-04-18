package cs1635.group.booksharing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class AppointmentsActivity extends ListActivity {
	AppointmentData[] apt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_layout);
		
		apt = new AppointmentData[3];
		apt[0] = new AppointmentData("John Smith", "01/01/13", "00:00", "Hillman Library", "Can we meet at the Hillman Library?");
		apt[1] = new AppointmentData("Jill Smith", "01/02/13", "00:02", "Starbucks on Forbes Ave", "Let's meet at the Starbucks on Forbes Ave");
		apt[2] = new AppointmentData("Jann Lee", "01/03/13", "10:00", "123 Main St, Pittsburgh, PA", "Great! Let's meet at the Starbucks on Main St at 10 tomorrow morning.");
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
		intent.putExtra("Location", apt[position].location);
		intent.putExtra("Date", apt[position].date);
		intent.putExtra("Time", apt[position].time);
		intent.putExtra("Message", apt[position].message);
		startActivity(intent);
	}
	
	// Called on Home button press
	public void goHome(View view) {
		finish();
	}
}
