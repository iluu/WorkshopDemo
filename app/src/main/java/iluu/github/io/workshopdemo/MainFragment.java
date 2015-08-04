package iluu.github.io.workshopdemo;

import com.melnykov.fab.FloatingActionButton;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
    private static final String ADD_SHOES_DIALOG = "add_shoes_dialog";

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final FloatingActionButton addButton = (FloatingActionButton) view.findViewById(R.id.add_button);

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddShoesDialogFragment dialog = new AddShoesDialogFragment();
                        dialog.show(getFragmentManager(), ADD_SHOES_DIALOG);
                    }
                }
        );

        return view;
    }

}
