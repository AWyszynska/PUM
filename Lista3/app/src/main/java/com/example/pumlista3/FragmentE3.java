package com.example.pumlista3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



public class FragmentE3 extends Fragment {

    private RecyclerView recyclerView;
    private TaskDetailsAdapter adapter;
    private ExerciseList selectedList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e3, container, false);


        if (getArguments() != null) {
            selectedList = getArguments().getParcelable("selectedList");
        }


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        if (selectedList != null) {
            List<Exercise> exercises = selectedList.getExercises();
            adapter = new TaskDetailsAdapter(exercises);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
