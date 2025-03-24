package chapter12;

import java.util.Map;

public class GradeBook {
    public static void main(String[] args) {
        Map<String, Integer> originalGrades = TestResults.getOriginalGrades();
        Map<String, Integer> makeUpGrades = TestResults.getMakeUpGrades();

        for (String student : originalGrades.keySet()) {
            int original = originalGrades.get(student);
            int makeup = makeUpGrades.getOrDefault(student, original);
            if (makeup > original) {
                originalGrades.put(student, makeup);
            }
        }

        System.out.println("Final Grades:");
        for (Map.Entry<String, Integer> entry : originalGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
