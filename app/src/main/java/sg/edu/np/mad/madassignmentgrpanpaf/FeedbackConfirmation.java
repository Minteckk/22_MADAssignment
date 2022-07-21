package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeedbackConfirmation extends AppCompatActivity {
    String StudentID;
    String StudentName;
    String feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_confirmation);

        // get the intent from Student Profile
        Intent i = getIntent();
        StudentName = i.getStringExtra("name");
        StudentID = i.getStringExtra("studentID");
        TextView studentID = findViewById(R.id.fbName);
        studentID.setText(StudentName);
        feedback = i.getStringExtra("Feedback");
        TextView givenfeedback = findViewById(R.id.infb);
        givenfeedback.setText(feedback);

        Button backToMain = findViewById(R.id.backToMain3);

        SharedPreferences prefs = getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeedbackConfirmation.this,LecturerMain.class);
                i.putExtra("Username",value);
                //i.putExtra("studentID",StudentID);
                startActivity(i);
            }
        });

    }
}