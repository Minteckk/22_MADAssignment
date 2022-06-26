package sg.edu.np.mad.madassignmentgrpanpaf;


import java.util.ArrayList;
import java.util.Date;

public class attendance {
String studentId;
String date;
String feedback;


    public attendance(String studentId, String date, String feedback) {
        this.studentId = studentId;
        this.date = date;
        this.feedback = feedback;
    }

    public attendance() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFeedback() {
            return this.feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setDate(String date) {this.date = date;}
    public String getDate() {return this.date;}
}
