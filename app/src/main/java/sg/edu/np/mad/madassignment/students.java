package sg.edu.np.mad.madassignment;

public class students {
    String Name;
    String StudentID;

    public students(String name, String studentID) {
        this.Name = name;
        this.StudentID = studentID;
    }

    public students() {}
    public void SetStudentID(String studentID) {this.StudentID = studentID;}
    public String getStudentID() {return this.StudentID;}
    public void setName(String name) {this.Name = name;}
    public String getName() {return this.Name;}
}