package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentViewFeedback extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_feedback);

        Intent i = new Intent();
        String studentId = i.getStringExtra("StudentID");
        //String studentName  = i.getStringExtra("StudentName");
        //String value = prefs.getString("KEY",studentName);
        //getStudentID.setText(value);
        //getStudentID.setText("S"+studentId);

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        // initialize attendance object
        attendance feedback = new attendance();
        // get Feedback from attendance object
        String SFB = feedback.getFeedback();
        // find the textview by id
        TextView fb = findViewById(R.id.student_view_feedback_feedback);
        // set the TextView text to the feedback
        fb.setText(SFB);
        // get the text of the textview and convert to string
        String fbstring = fb.getText().toString();

        // if the string is empty, set the text to No feedback given
        if (fbstring.isEmpty() == true) {
            fb.setText("No feedbacks given.");
        }


        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_view_feedback_back);
        // set OnClickListener
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Student Main Page
                Intent i = new Intent(StudentViewFeedback.this, StudentMain.class);
                i.putExtra("StudentID",value);
                // start activity
                startActivity(i);
            }
        });
    }
}