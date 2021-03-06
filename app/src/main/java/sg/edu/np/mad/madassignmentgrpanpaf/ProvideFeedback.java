package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProvideFeedback extends AppCompatActivity {
    // global variable for submit button
    private Button submitBtn;
    // variable for feedback multi-line text
    private EditText feedbackInput;
    String feedback;
    String StudentID;
    ArrayList<attendance>feedbackList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_feedback);

        // get the intent from Student Profile
        Intent i = getIntent();

        // receiving the intent
        String name = i.getStringExtra("name");
        StudentID = i.getStringExtra("studentID");
        String lecUsername = i.getStringExtra("Username");

        // find the textview for studentName
        TextView studentName = findViewById(R.id.feedbackStudentName);

        // set the textview text as Student name
        studentName.setText(name);

        // find the textview for studentID
        TextView studentID = findViewById(R.id.feedbackStudentID);

        // set the textview for studentID
        studentID.setText(String.valueOf(StudentID));

        // find the id for feedback input field
        feedbackInput = findViewById(R.id.feedbackInput);

        // find the id for submit feedback button
        Button submitBtn = findViewById(R.id.SubmitFeedback);

        //feedbackList = initializeFeedback();

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.provide_feedback_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProvideFeedback.this, StudentProfile.class);
                i.putExtra("name", name);
                i.putExtra("studentID", StudentID);
                i.putExtra("Username",lecUsername);
                startActivity(i);
            }
        });

        // set the OnclickListener for the submit feedback button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the text in the input field and convert what the user has input to string
                feedback = feedbackInput.getText().toString();
                // if input field is empty, set an error to let users to know what is the error.
                if(feedback.length()==0) {
                    feedbackInput.requestFocus();
                    feedbackInput.setError("Please enter your feedback on performance of your students");
                }
                else {
                    // toast message to inform user that feedback has been given successfully.
                    Toast.makeText(ProvideFeedback.this, "Feedback given successfully!", Toast.LENGTH_SHORT).show();
                    //feedbackList =
                    feedbackList = initializeFeedback(feedbackList);
                    Intent i = new Intent(ProvideFeedback.this,FeedbackConfirmation.class);
                    i.putExtra("Feedback",feedback);
                    i.putExtra("name", name);
                    i.putExtra("studentID", StudentID);
                    startActivity(i);
                }
            }
        });
    }

    public ArrayList<attendance> initializeFeedback(ArrayList<attendance> feedbackList) {
        P01Handler db = new P01Handler(this);
        feedbackList = db.getFeedback();
        if(feedbackList.size() == 0) {
            String id = String.valueOf(StudentID);
            String Studentfeedback = feedbackInput.getText().toString();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String feedbackDate = simpleDateFormat.format(calendar.getTime()).toString();
            attendance Newfeedback = new attendance(id,feedbackDate,Studentfeedback);
            feedbackList.add(Newfeedback);
        }
        // update the student to database.
        for (int b = 0; b < feedbackList.size(); b++) {
            db.addFeedback(feedbackList.get(b));
        }
        return feedbackList;
    }
}