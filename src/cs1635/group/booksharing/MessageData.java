package cs1635.group.booksharing;

public class MessageData {
	String sender;
	String date;
	String time;
	String message;
	
	public MessageData (String sender, String date, String time, String message) {
		this.sender = sender;
		this.date = date;
		this.time = time;
		this.message = message;
	}
}
