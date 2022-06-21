package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentViewFeedback extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_feedback);

        attendance feedback = new attendance();
        String SFB = feedback.getFeedback();
        TextView fb = findViewById(R.id.student_view_feedback_feedback);
        fb.setText(SFB);
        String fbstring = fb.getText().toString();
        if (fbstring.isEmpty() == true) {
            fb.setText("No feedbacks given.");
        }


        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_view_feedback_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentViewFeedback.this, StudentMain.class);
                startActivity(i);
            }
        });
    }


}