package cs1635.group.booksharing;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ConfirmDeleteMessageDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.confirm_delete_message_dialog);
		
		// Confirm button
		builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// Display confirmation dialog
				DialogFragment confirmationDialog = new MessageDeletedDialogFragment();
				confirmationDialog.show(getFragmentManager(), "MessageDeletedDialogFragment");
			}
		});
		
		// Cancel button
		builder.setNegativeButton(R.string.never_mind, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				
			}
		});
		
		return builder.create();
	}
}