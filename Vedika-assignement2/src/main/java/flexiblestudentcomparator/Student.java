package flexiblestudentcomparator;

import java.util.Comparator;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private double score;
    private int age;

    public Student(int id, String name, double score, int age) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public Student() {
        this.id = 0;
        this.name = " ";
        this.score = 0;
        this.age = 0;
    }

    @Override
    public String toString() {
        return "ID : " + id + "\n" + "Name : " + name + "\n" + "Score : " + score + "\n" + "Age: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(score, student.score) == 0 && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class StudentComparator implements Comparator<Student> {
        private String sortType;

        public StudentComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Student s1, Student s2) {
            switch (sortType) {
                case "scores":
                    int ScoreComparison = Double.compare(s2.getScore(), s1.getScore());
                    if (ScoreComparison != 0) {
                        return ScoreComparison;
                    }
                    return Integer.compare(s1.getAge(), s2.getAge());
                case "name":
                    int nameComparison = s1.getName().compareTo(s2.getName());
                    if (nameComparison != 0) {
                        return nameComparison;
                    }
                    return Integer.compare(s1.getId(), s2.getId());

                default:
                    int idComparison = Integer.compare(s1.getId(), s2.getId());
                    if (idComparison != 0) {
                        return idComparison;
                    }
                    return Integer.compare(s2.age, s1.getAge());
            }
        }
    }
}


