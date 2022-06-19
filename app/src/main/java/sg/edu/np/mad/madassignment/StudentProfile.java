package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StudentProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        // get the intent
        Intent i = getIntent();
        // receiving the intent
        String name = i.getStringExtra("name");
        String StudentID = i.getStringExtra("studentID");
        // find the textview
        TextView n = findViewById(R.id.textView18);
        // set the textview text as StudentName
        n.setText(name);
        // find the textview
        TextView id = findViewById(R.id.textView19);
        // set the textview text as StudentID
        id.setText(StudentID);
        // find the id for the feedback button
        Button feedbackBtn = findViewById(R.id.ProvideFeedback);
        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_profile_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentProfile.this, ViewAllStudents.class);
                startActivity(i);
            }
        });
        // set OnClick listener for the feedback button
        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to the provide feedback page
                Intent feedbackIntent = new Intent(StudentProfile.this, ProvideFeedback.class);
                // send the intent to ProvideFeedback class
                feedbackIntent.putExtra("name", name);
                feedbackIntent.putExtra("studentID", StudentID);
                // start the activity
                startActivity(feedbackIntent);
            }
        });
    }
}