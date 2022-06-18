package sg.edu.np.mad.madassignment;

import android.widget.ImageView;

public class students {
    String Name;
    String StudentID;
    Boolean AttendanceStatus;

    public students(String name, String studentID, Boolean attendanceStatus) {
        this.Name = name;
        this.StudentID = studentID;
        this.AttendanceStatus = attendanceStatus;
    }

    public students() {}
    public void SetStudentID(String studentID) {this.StudentID = studentID;}
    public String getStudentID() {return this.StudentID;}
    public void setName(String name) {this.Name = name;}
    public String getName() {return this.Name;}
    public void setAttendanceStatus(Boolean attendanceStatus) {this.AttendanceStatus = attendanceStatus;}
    public Boolean getAttendanceStatus() {return this.AttendanceStatus;}
}