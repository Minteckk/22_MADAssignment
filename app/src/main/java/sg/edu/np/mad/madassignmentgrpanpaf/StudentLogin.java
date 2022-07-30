package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        // find the id of the student ID and password input field
        EditText getStudentID = findViewById(R.id.student_studentid);
        EditText getStudentPassword = findViewById(R.id.student_pw);

        // find the id of student login button
        Button student_login = findViewById(R.id.button);
        // set OnClickListener
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the input entered and convert to string
                String studentID = getStudentID.getText().toString();
                String studentPassword = getStudentPassword.getText().toString();

                // if studentID is empty, set error message as "Please enter your student id"
                if(studentID.length()==0) {
                    getStudentID.requestFocus();
                    getStudentID.setError("Please enter your student id");
                }
                // if studentID is less than 8, set error message as "Student ID is 8 digits"
                else if(studentID.length() < 8)
                {
                    getStudentID.requestFocus();
                    getStudentID.setError("Student ID is 8 digits");
                } else if(!studentID.startsWith("1")) {
                    getStudentID.requestFocus();
                    getStudentID.setError("Invalid student ID");
                }
                else if(studentID.length() > 8) {
                    getStudentID.requestFocus();
                    getStudentID.setError("Student ID is 8 digits");
                }
                // if studentPassword is empty, set error message as "Please enter your password!"
                else if(studentPassword.length() == 0) {
                    getStudentPassword.requestFocus();
                    getStudentPassword.setError("Please enter your password");
                }
                // if password is less than 6, set error message
                else if(studentPassword.length() < 6) {
                    getStudentPassword.requestFocus();
                    getStudentPassword.setError("Password must be more than 6 characters");
                }
                else {
                    // go to student main page after successful login
                    Intent intent = new Intent(StudentLogin.this, MainStudent.class);
                    // toast message for login successful
                    Toast.makeText(StudentLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    //intent.putExtra("StudentName",studentName);
                    intent.putExtra("StudentID",studentID);
                    // start activity
                    startActivity(intent);
                }
            }
        });
        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_login_back);
        // onClick listener for back button
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // set Onclick listener for register button
        TextView register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to register page
                Intent register = new Intent(StudentLogin.this, register.class);
                // start activity
                startActivity(register);
            }
        });
    }
}