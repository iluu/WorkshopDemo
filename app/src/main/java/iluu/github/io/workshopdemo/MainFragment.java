package iluu.github.io.workshopdemo;

import com.melnykov.fab.FloatingActionButton;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements AddShoesDialogFragment.AddShoesDialogListener {
    private static final String ADD_SHOES_DIALOG = "add_shoes_dialog";
    private ShoesAdapter adapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        loadShoeData();
        initActionButton(view);
        initRecyclerView(view);

        return view;
    }

    @Override
    public void onShoesAdded(Shoes newShoes) {
        adapter.addItem(newShoes);
    }

    private List<Shoes> loadShoeData() {
        List<Shoes> shoes = new ArrayList<>();
        shoes.add(new Shoes("Adidas", 12));
        shoes.add(new Shoes("Calvin Klein", 11));
        return shoes;
    }

    private void initRecyclerView(View view) {
        adapter = new ShoesAdapter(loadShoeData());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void initActionButton(View view) {
        final FloatingActionButton addButton = (FloatingActionButton) view.findViewById(R.id.add_button);

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddShoesDialogFragment dialog = new AddShoesDialogFragment();
                        dialog.setOnShoesAddedListener(MainFragment.this);
                        dialog.show(getFragmentManager(), ADD_SHOES_DIALOG);
                    }
                }
        );
    }

}
