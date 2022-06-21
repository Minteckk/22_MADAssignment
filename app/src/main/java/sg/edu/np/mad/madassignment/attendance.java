package sg.edu.np.mad.madassignment;

public class attendance {
String studentId;
String feedback;

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
        if (feedback.isEmpty() == true) {
            String i = "No feedback given.";
            return i;
        }
        else {
            return feedback;
        }
    }


    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
