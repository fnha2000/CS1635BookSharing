package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MessageDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_detail);
		Intent intent = getIntent();
		String sender = intent.getStringExtra("Sender");
		String date = intent.getStringExtra("Date");
		String time = intent.getStringExtra("Time");
		String message = intent.getStringExtra("Message");
		TextView senderView = (TextView)findViewById(R.id.msgdetail_from);
		TextView dateView = (TextView)findViewById(R.id.msgdetail_date);
		TextView timeView = (TextView)findViewById(R.id.msgdetail_time);
		TextView messageView = (TextView)findViewById(R.id.msgdetail_content);
		senderView.setText(sender);
		dateView.setText(date);
		timeView.setText(time);
		messageView.setText(message);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_message_detail, menu);
		return true;
	}

	public void goBack(View v) {
		finish();
	}
	
	public void deleteMsg(View v) {
		
	}
	
	public void reply(View v) {
		
	}
}
