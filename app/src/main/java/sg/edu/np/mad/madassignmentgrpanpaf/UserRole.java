package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserRole extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_role);

        // find the student image id
        ImageView student = findViewById(R.id.student_role);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to student login page after a student click on Student image
                Intent studentIntent = new Intent(UserRole.this, StudentLogin.class);
                // start activity
                startActivity(studentIntent);
            }
        });

        // find the teacher image id
        ImageView teacher = findViewById(R.id.teacherRole);
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to lecturer login after a teacher click on Teacher image
                Intent lecturerIntent = new Intent(UserRole.this, LecturerLogin.class);
                // start activity
                startActivity(lecturerIntent);
            }
        });

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_login_back2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go back to main page
                finish();
            }
        });
    }
}