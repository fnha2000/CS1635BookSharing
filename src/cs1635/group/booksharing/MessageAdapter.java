package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MessageAdapter extends ArrayAdapter<MessageData> {
	private final Context context;
	private MessageData[] messages;
	
	public MessageAdapter(Context context, int layoutResourceId, MessageData[] messages) {
		super(context, R.layout.message_layout, messages);
		this.context = context;
		this.messages = messages;
	}
	
	@Override
	public int getCount() {
		return messages != null ? messages.length : 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) ((Activity)context).getLayoutInflater();
		View tweetView = inflater.inflate(R.layout.message_layout, parent, false);
		TextView senderText = (TextView)tweetView.findViewById(R.id.sender);
		TextView dateText = (TextView)tweetView.findViewById(R.id.senddate);
		TextView timeText = (TextView)tweetView.findViewById(R.id.sendtime);
		TextView contentText = (TextView)tweetView.findViewById(R.id.message);
		MessageData curMessage = messages[position];
		senderText.setText(curMessage.sender);
		dateText.setText(curMessage.date);
		timeText.setText(curMessage.time);
		String message = curMessage.message;
		if (message.length() > 40) {
			message = message.substring(0, 37) + "...";
		}
		contentText.setText(message);
		return tweetView;
	}
}
