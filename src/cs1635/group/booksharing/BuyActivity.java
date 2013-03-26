// NOTE: Lots of errors here, but I'm not sure what's wrong. Either I'm confused or Eclipse is buggy.

package cs1635.group.booksharing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BuyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy, menu);
		return true;
	}
	
	// Called on Buy button press
	public void goToButton(View view) {
		Intent intent = new Intent(this, BuyBookDetailsActivity.class);
		startActivity(intent);
	}
	
	// Handles Search button press on soft keyboard
	// NOTE: These are just hardcoded dummy results.
    EditText editText = (EditText) findViewById(R.id.editText1);
    
    // Create layout for list
    LinearLayout listLayout = new LinearLayout(this);
    listLayout.setOrientation(LinearLayout.VERTICAL);
    LinearLayout parentLayout = (LinearLayout)this.findViewById(R.id.results_list);
    parentLayout.addView(listLayout);
    
    // Create layout for item
 	final LinearLayout itemLayout = new LinearLayout(this);
 	listLayout.setOrientation(LinearLayout.HORIZONTAL);
    
 	// Create image
    final ImageView image = new ImageView(this);
    int resID = getResources().getIdentifier("android_text_photo", "drawable", getPackageName());	// Get resource ID of image
    image.setImageResource(resID);
    
    // Create nested layout
    final LinearLayout nestedLayout = new LinearLayout(this);
    listLayout.setOrientation(LinearLayout.VERTICAL);
    
    // Create text labels
    final TextView title = new TextView(this);
    title.setText(getResources().getString(R.string.sample_title));
    
    final TextView price = new TextView(this);
    price.setText(getResources().getString(R.string.sample_price));
    
    // Create button
    final Button buyButton = new Button(this);
    buyButton.setText(getResources().getString(R.string.buy));
    
    editText.setOnEditorActionListener(new OnEditorActionListener() {
    	@Override
    	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    		boolean handled = false;
			
			if (actionId == EditorInfo.IME_ACTION_DONE) {
    			// Close keyboard
    			InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    			handled = true;
    			
    			// Display search results
    			listLayout.addView(itemLayout);
    			itemLayout.addView(image);
    			itemLayout.addView(nestedLayout);
    			nestedLayout.addView(title);
    			nestedLayout.addView(price);
    			itemLayout.addView(buyButton);  			
    		}
    		
    		return handled;
    	}
    });

}
