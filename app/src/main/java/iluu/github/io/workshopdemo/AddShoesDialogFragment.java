package iluu.github.io.workshopdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddShoesDialogFragment extends DialogFragment {
    private EditText brandInput;
    private EditText sizeInput;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.new_shoes)
                .setView(createInputForm())
                .setPositiveButton(R.string.add_shoes, null)
                .setNegativeButton(R.string.cancel, null)
                .show();

        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Shoes shoes = new Shoes(getBrand(brandInput), getSize(sizeInput));

                if (shoes.isValid()) {
                    dialog.dismiss();
                    Toast.makeText(getActivity(), getString(R.string.new_shoes_added, shoes.brand, shoes.size), Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        return dialog;
    }

    private View createInputForm() {
        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_shoes, null);
        brandInput = (EditText) view.findViewById(R.id.brand_input);
        sizeInput = (EditText) view.findViewById(R.id.size_input);

        return view;
    }

    private String getBrand(EditText brandInput) {
        String brand = brandInput.getText().toString();
        if (TextUtils.isEmpty(brand)) {
            brandInput.setError(getString(R.string.error_required));
        }
        return brand;
    }

    private int getSize(EditText sizeInput) {
        String size = sizeInput.getText().toString();
        if (TextUtils.isEmpty(size)) {
            sizeInput.setError(getString(R.string.error_required));
            return Shoes.INVALID_SIZE;
        }
        return Integer.parseInt(size);
    }
}
