package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        // find the id of student login button
        Button student_login = findViewById(R.id.button);
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLogin.this, StudentMain.class);
                startActivity(intent);
            }
        });
        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_login_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentLogin.this, MainActivity.class);
                startActivity(i);
            }
        });
        // set Onclick listener for register button
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(StudentLogin.this, register.class);
                startActivity(register);
            }
        });
    }
}