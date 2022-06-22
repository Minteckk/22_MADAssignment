package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference studentsRef = database.getReference("Students");
        DatabaseReference studentMod = studentsRef.child("MAD");
        DatabaseReference studentsRef2 = database.getReference("MAD");

        // find the lecturer login button id
        Button lecturer_login = findViewById(R.id.lecturerlogin);

        // set the onClick listener for lecturer log in button
        lecturer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to lecturer login page after a lecturer selects on lecturer login
                Intent lecturerIntent = new Intent(MainActivity.this,LecturerLogin.class);
                startActivity(lecturerIntent);
            }
        });

        // find the student login button id
        Button student_login = findViewById(R.id.Studentlogin);

        // set the onClick listen for student log in button
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to student login page after a student select on student login
                Intent studentIntent = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(studentIntent);
            }
        });
    }
}