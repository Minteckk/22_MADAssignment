package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // find the id of register button
        Button registerBtn = findViewById(R.id.registerBtn);
        // find the id of the student Name, ID and password
        EditText sName = findViewById(R.id.reg_StudentName);
        EditText sID = findViewById(R.id.reg_studentID);
        EditText password = findViewById(R.id.regStudentPassword);

        // set OnClickListener for the register button
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the input data and convert to string
               String studentName = sName.getText().toString();
               String studentID = sID.getText().toString();
               String studentPassword = password.getText().toString();

                //SharedPreferences.Editor editor = getSharedPreferences("studentName",MODE_PRIVATE).edit();
                //editor.putString("KEY",studentName);
                //editor.apply();

               // if name is empty, set error
               if(studentName.isEmpty()) {
                   sName.requestFocus();
                   sName.setError("Please enter your name");
               }
               // if student ID is empty, set error
               if(studentID.length()==0) {
                   sID.requestFocus();
                   sID.setError("Please enter your Student ID");
               }
               // if studentID is less than 8 digits, set error
               else if(studentID.length() < 8) {
                   sID.requestFocus();
                   sID.setError("Student ID must be 8 digits");
               }
               // if password is empty, set error
               if(studentPassword.isEmpty()) {
                   password.requestFocus();
                   password.setError("Please set a password");
               }
               // if password is less than 6 characters, set error
               else if(studentPassword.length() < 6) {
                   password.requestFocus();
                   password.setError("Password must be at least 6 characters");
               }
               // else, show toast message - registration successful
               else {
                   Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(register.this, StudentLogin.class);
                   startActivity(i);
               }
            }
        });
        // find the textView for loginNow
        TextView loginNow = findViewById(R.id.loginNow);
        // set the OnClickListener
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String studentName = sName.getText().toString();
                //String studentID = sID.getText().toString();
                // back to studentLogin page
                Intent backtoLogin = new Intent(register.this, StudentLogin.class);
                //backtoLogin.putExtra("StudentName",studentName);
                //backtoLogin.putExtra("StudentID", studentID);
                startActivity(backtoLogin);
            };
    });
    }
}