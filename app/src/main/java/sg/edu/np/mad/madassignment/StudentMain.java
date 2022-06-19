package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        // set Onclick listener for attendance image view
        ImageView iv = findViewById(R.id.student_aimage);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentMain.this, StudentTakeAttendance.class);
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


    }
}