package iluu.github.io.workshopdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText brandInput = (EditText) view.findViewById(R.id.brand_input);
        final EditText sizeInput = (EditText) view.findViewById(R.id.size_input);
        final Button addButton = (Button) view.findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = brandInput.getText().toString();
                int size = Integer.parseInt(sizeInput.getText().toString());

                Toast.makeText(getActivity(), getString(R.string.new_shoes_added, brand, size), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return view;
    }
}
