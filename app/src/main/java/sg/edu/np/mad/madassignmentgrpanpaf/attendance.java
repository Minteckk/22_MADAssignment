package sg.edu.np.mad.madassignmentgrpanpaf;


import java.util.ArrayList;
import java.util.Date;

public class attendance {
int studentId;
String date;
String feedback;


    public attendance(int studentId, String date, String feedback) {
        this.studentId = studentId;
        this.date = date;
        this.feedback = feedback;
    }

    public attendance() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
