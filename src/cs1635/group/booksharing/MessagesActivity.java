package cs1635.group.booksharing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MessagesActivity extends ListActivity {
	MessageData[] msg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		
		msg = new MessageData[2];
		msg[0] = new MessageData("John Smith", "01/01/13", "00:00", "I'd like to buy your Programming for Android textbook. Do you still have it?");
		msg[1] = new MessageData("John Smith", "01/01/13", "00:02", "Is this still available?");
		MessageAdapter messages = new MessageAdapter(this, R.layout.message_layout, msg);
		setListAdapter(messages);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_messages, menu);
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
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, MessageDetailActivity.class);
		intent.putExtra("Sender", msg[position].sender);
		intent.putExtra("Date", msg[position].date);
		intent.putExtra("Time", msg[position].time);
		intent.putExtra("Message", msg[position].message);
		startActivity(intent);
	}
	
	// Called on Home button press
	public void goHome(View view) {
		finish();
	}
}
