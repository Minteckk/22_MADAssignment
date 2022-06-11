package sg.edu.np.mad.madassignment;

public class students {
    String Name;
    int StudentID;

    public students(String name, int studentID) {
        this.Name = name;
        this.StudentID = studentID;
    }

    public students() {}
    public void SetStudentID(int studentID) {this.StudentID = studentID;}
    public int getStudentID() {return this.StudentID;}
    public void setName(String name) {this.Name = name;}
    public String getName() {return this.Name;}
}