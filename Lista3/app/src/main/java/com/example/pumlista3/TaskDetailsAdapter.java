package com.example.pumlista3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pumlista3.databinding.ItemTaskDetailBinding;
import java.util.List;

public class TaskDetailsAdapter extends RecyclerView.Adapter<TaskDetailsAdapter.TaskDetailViewHolder> {

    private final List<Exercise> exercises;

    public TaskDetailsAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public TaskDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTaskDetailBinding binding = ItemTaskDetailBinding.inflate(inflater, parent, false);
        return new TaskDetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskDetailViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.bind(position + 1, exercise);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class TaskDetailViewHolder extends RecyclerView.ViewHolder {
        private final ItemTaskDetailBinding binding;

        public TaskDetailViewHolder(ItemTaskDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int taskNumber, Exercise exercise) {
            binding.textViewTaskNumber.setText("Zadanie " + taskNumber);
            binding.textViewTaskContent.setText(exercise.getContent());
            binding.textViewTaskPoints.setText("Punkty: " + exercise.getPoints());
        }
    }
}
