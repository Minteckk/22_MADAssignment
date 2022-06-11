package sg.edu.np.mad.madassignment;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference studentsRef = database.getReference("Students");
        DatabaseReference studentMod = studentsRef.child("MAD");
        DatabaseReference studentsRef2 = database.getReference("MAD");

        Button lecturer_login = findViewById(R.id.lecturerlogin);
        lecturer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lecturerIntent = new Intent(MainActivity.this,LecturerLogin.class);
                startActivity(lecturerIntent);
            }
        });
        Button student_login = findViewById(R.id.Studentlogin);
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentIntent = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(studentIntent);
            }
        });
    }
}