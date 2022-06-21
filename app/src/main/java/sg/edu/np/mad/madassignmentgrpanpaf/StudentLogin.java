package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        EditText getStudentID = findViewById(R.id.student_studentid);
        EditText getStudentPassword = findViewById(R.id.student_pw);

        // find the id of student login button
        Button student_login = findViewById(R.id.button);
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentID = getStudentID.getText().toString();
                String studentPassword = getStudentPassword.getText().toString();
                if(studentID.length()==0) {
                    getStudentID.requestFocus();
                    getStudentID.setError("Please enter your student id");
                }
                else if(studentID.length() < 8)
                {
                    getStudentPassword.requestFocus();
                    getStudentID.setError("Student ID is 8 digits");
                }
                if(studentPassword.length() == 0) {
                    getStudentPassword.requestFocus();
                    getStudentPassword.setError("Please enter your password");
                }
                else if(studentPassword.length() < 6) {
                    getStudentPassword.requestFocus();
                    getStudentPassword.setError("Password must be more than 6 characters");
                }
                else {
                    Intent intent = new Intent(StudentLogin.this, StudentMain.class);
                    startActivity(intent);
                }
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