package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AppointmentAdapter extends ArrayAdapter<AppointmentData> {
	private final Context context;
	private AppointmentData[] appointments;
	
	public AppointmentAdapter(Context context, int layoutResourceId, AppointmentData[] appointments) {
		super(context, R.layout.appointment_layout, appointments);
		this.context = context;
		this.appointments = appointments;
	}
	
	@Override
	public int getCount() {
		return appointments != null ? appointments.length : 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) ((Activity)context).getLayoutInflater();
		View tweetView = inflater.inflate(R.layout.appointment_layout, parent, false);
		TextView senderText = (TextView)tweetView.findViewById(R.id.apntmnt);
		TextView dateText = (TextView)tweetView.findViewById(R.id.aptdate);
		TextView timeText = (TextView)tweetView.findViewById(R.id.apttime);
		TextView locationText = (TextView)tweetView.findViewById(R.id.location);
		AppointmentData curMessage = appointments[position];
		senderText.setText(curMessage.appointwith);
		dateText.setText(curMessage.date);
		timeText.setText(curMessage.time);
		locationText.setText(curMessage.location);
		return tweetView;
	}
}
