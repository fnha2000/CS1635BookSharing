package cs1635.group.booksharing;

public class AppointmentData {
	String appointwith;
	String date;
	String time;
	String location;
	String message;
	
	public AppointmentData (String appointwith, String date, String time, String location, String message) {
		this.appointwith = appointwith;
		this.date = date;
		this.time = time;
		this.location = location;
		this.message = message;
	}
}
