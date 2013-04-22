package cs1635.group.booksharing;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AppointmentMapActivity extends FragmentActivity {
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment_map);
		
		setUpMapIfNeeded();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appointment_map, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}
	
	// Do we actually need this?
	private void setUpMapIfNeeded() {
		if (map == null) {
			System.out.println("map is null!");
			map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
			
			if (map != null) {
				finishSetup();
			}
		}
	}
	
	private void finishSetup() {
		map.addMarker(new MarkerOptions().position(new LatLng(40.44151, -79.95635)).title("Appointment location"));
	}

}
