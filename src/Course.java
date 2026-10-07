public class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    /** Create a course with the specified name */
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[10]; // Initial capacity of 10
        this.numberOfStudents = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    /** Add a new student to the course (with dynamic resizing if full) */
    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            // Expand array capacity (doubling the size)
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    /** Drop a student from the course */
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                break;
            }
        }
    }

    /** Returns the list of enrolled students */
    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}