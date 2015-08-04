package iluu.github.io.workshopdemo;

import com.melnykov.fab.FloatingActionButton;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainFragment extends Fragment {
    private final int INVALID_SIZE = -1;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText brandInput = (EditText) view.findViewById(R.id.brand_input);
        final EditText sizeInput = (EditText) view.findViewById(R.id.size_input);
        final FloatingActionButton addButton = (FloatingActionButton) view.findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = getBrand(brandInput);
                int size = getSize(sizeInput);

                if (!TextUtils.isEmpty(brand) && size != INVALID_SIZE) {
                    Toast.makeText(getActivity(), getString(R.string.new_shoes_added, brand, size), Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

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
            return INVALID_SIZE;
        }
        return Integer.parseInt(size);
    }

}
