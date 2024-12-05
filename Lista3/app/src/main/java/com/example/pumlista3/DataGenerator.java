package com.example.pumlista3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static final String[] SUBJECTS = {"Matematyka", "PUM", "Fizyka", "Elektronika", "Algorytmy"};
    private static final Random RANDOM = new Random();

    public static List<ExerciseList> generateDummyData() {
        List<ExerciseList> exerciseLists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            Subject subject = new Subject(SUBJECTS[RANDOM.nextInt(SUBJECTS.length)]);
            float grade = 3.0f + (RANDOM.nextInt((int) ((5.0 - 3.0) / 0.5)) * 0.5f);
            List<Exercise> exercises = new ArrayList<>();
            int exerciseCount = RANDOM.nextInt(10) + 1;

            for (int j = 0; j < exerciseCount; j++) {
                exercises.add(new Exercise("Zrobic zadanie w ksiazce numer " + RANDOM.nextInt(100), RANDOM.nextInt(10) + 1));
            }

            exerciseLists.add(new ExerciseList(exercises, subject, grade));
        }
        return exerciseLists;
    }
}
