package sg.edu.np.mad.madassignmentgrpanpaf;

public class students {
    String Name;
    String StudentID;
    String StudentClass;
    Boolean AttendanceStatus;

    public students(String name, String studentID, String studentClass, Boolean attendanceStatus) {
        this.Name = name;
        this.StudentID = studentID;
        this.StudentClass = studentClass;
        this.AttendanceStatus = attendanceStatus;
    }

    public students() {}
    public void SetStudentID(String studentID) {this.StudentID = studentID;}
    public String getStudentID() {return this.StudentID;}
    public void setName(String name) {this.Name = name;}
    public String getName() {return this.Name;}
    public void setStudentClass(String studentClass) {this.StudentClass = studentClass;}
    public String getStudentClass() {
        return StudentClass;
    }
    public void setAttendanceStatus(Boolean attendanceStatus) {this.AttendanceStatus = attendanceStatus;}
    public Boolean getAttendanceStatus() {return this.AttendanceStatus;}
}