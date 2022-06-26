package sg.edu.np.mad.madassignmentgrpanpaf;

import java.util.ArrayList;

public class attendance {
String studentId;
String feedback;
ArrayList<attendance>feedbackList;

    public attendance(String studentId, String feedback) {
        this.studentId = studentId;
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

    public ArrayList<attendance> setFeedback(String feedback, String studentId) {
        this.feedback = feedback;
        this.studentId = studentId;
        return feedbackList;
    }
}
