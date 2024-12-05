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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentE2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e2, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        List<ExerciseList> exerciseLists = DataGenerator.generateDummyData();


        Map<String, Float> subjectAverages = calculateAverageGrades(exerciseLists);


        GradeListAdapter adapter = new GradeListAdapter(subjectAverages);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private Map<String, Float> calculateAverageGrades(List<ExerciseList> exerciseLists) {
        Map<String, Float> subjectAverages = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();

        for (ExerciseList list : exerciseLists) {
            String subjectName = list.getSubject().getName();
            float grade = list.getGrade();


            subjectAverages.put(subjectName, subjectAverages.getOrDefault(subjectName, 0f) + grade);
            subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
        }

        for (Map.Entry<String, Float> entry : subjectAverages.entrySet()) {
            String subject = entry.getKey();
            float totalGrade = entry.getValue() != null ? entry.getValue() : 0f;
            int count = subjectCounts.getOrDefault(subject, 0);

            if (count > 0) {
                subjectAverages.put(subject, totalGrade / count);
            }
        }

        return subjectAverages;
    }
}
