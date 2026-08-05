package lesson_6;
import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;

public class LessonSix {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Бобик", "Группа А", 1, Arrays.asList(3, 4, 3, 3)));
        students.add(new Student("Джеки Чан", "Группа А", 1, Arrays.asList(3, 4, 3, 5)));
        students.add(new Student("Стив Джобс", "Группа А", 1, Arrays.asList(2, 2, 3, 2)));
        students.add(new Student("Сталин", "Группа Б", 2, Arrays.asList(5, 5, 4, 5)));
        students.add(new Student("Акира", "Группа Б", 2, Arrays.asList(3, 3, 3, 3)));

        UniversityManager.removeBadGradesStudents(students);

        UniversityManager.promoteGoodGradesStudents(students);

        UniversityManager.printStudents(students, 2);
    }
}

