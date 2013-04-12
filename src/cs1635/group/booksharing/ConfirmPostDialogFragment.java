package cs1635.group.booksharing;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ConfirmPostDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.confirm_post_dialog);
		builder.setPositiveButton(R.string.home, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// Go to home screen.
				Intent intent = new Intent(getActivity(), Home.class);
				startActivity(intent);
			}
		});
		return builder.create();
	}
}
