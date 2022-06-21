package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentViewFeedback extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_feedback);




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

    public String getFeedback() {
        String feedback = attendance.getFeedback();
        TextView fb = findViewById(R.id.student_view_feedback_feedback);
        fb.setText(feedback);

    }




}