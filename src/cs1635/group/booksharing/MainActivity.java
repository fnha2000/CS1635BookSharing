package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Intent myIntent;
	Button signIn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		signIn = (Button) this.findViewById(R.id.signInButton);
		signIn.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View view){
				myIntent = new Intent(MainActivity.this, Home.class);
				MainActivity.this.startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
