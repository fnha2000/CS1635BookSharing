package cs1635.group.booksharing;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class MessageReplyActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_reply);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.message_reply, menu);
		return true;
	}
	
	// Called on "Send" button click.
	public void reply(View view) {
		DialogFragment dialog = new SendConfirmationDialogFragment();
		dialog.show(getSupportFragmentManager(), "SendConfirmationDialogFragment");
	}

}
