package cs1635.group.booksharing;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MessagesActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		MessageData[] msg = new MessageData[2];
		msg[0] = new MessageData("John Smith", "01/01/13", "00:00", "I'd like to buy...");
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
}
