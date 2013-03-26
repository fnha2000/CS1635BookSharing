package cs1635.group.booksharing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Home extends Activity {

	Intent myIntent;
	ImageButton help;
	ImageButton profile;
	ImageButton buy;
	ImageButton sell;
	ImageButton messages;
	ImageButton appointments;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		buy = (ImageButton) this.findViewById(R.id.buyButton);
		buy.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, BuyActivity.class);
				Home.this.startActivity(myIntent);
			}
		});
		
		sell = (ImageButton) this.findViewById(R.id.sellButton);
		sell.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, SellActivity.class);
				Home.this.startActivity(myIntent);
			}
		});
		
		help = (ImageButton) this.findViewById(R.id.helpButton);
		help.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, Help.class);
				Home.this.startActivity(myIntent);
			}
		});
		
		profile = (ImageButton) this.findViewById(R.id.profileButton);
		profile.setOnClickListener(new OnClickListener(){
		
			@SuppressLint("NewApi")	// Just a kludgy fix for the API problem for now.
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, Profile.class);	// API problem here.
				Home.this.startActivity(myIntent);
			}
		});
		
		messages = (ImageButton) this.findViewById(R.id.messagesButton);
		messages.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, MessagesActivity.class);
				Home.this.startActivity(myIntent);
			}
		});
		
		appointments = (ImageButton) this.findViewById(R.id.appointmentsButton);
		appointments.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(Home.this, AppointmentsActivity.class);
				Home.this.startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}
