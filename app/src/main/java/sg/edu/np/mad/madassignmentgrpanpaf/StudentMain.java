package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);


        // set the onClick listener for the logout button
        Button btn = findViewById(R.id.button_logout2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, MainActivity.class);
                // Close all activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Add a new flag to start new activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        // set Onclick listener for attendance image view
        ImageView iv2 = findViewById(R.id.student_aimage);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, StudentTakeAttendance.class);
                startActivity(i);
            }
        });

        // set Onclick listener for feedback image view
        ImageView iv3 = findViewById(R.id.student_fimage);
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, StudentViewFeedback.class);
                startActivity(i);
            }
        });

        // set Onclick listener for the attendance text
        TextView tv = findViewById(R.id.student_atext);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, StudentTakeAttendance.class);
                startActivity(i);
            }
        });

        // set Onclick listener for the attendance text
        TextView tv2 = findViewById(R.id.student_ftext);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, StudentViewFeedback.class);
                startActivity(i);
            }
        });


    }
}