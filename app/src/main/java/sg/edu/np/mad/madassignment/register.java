package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Button registerBtn = findViewById(R.id.registerBtn);
        EditText sName = findViewById(R.id.reg_StudentName);
        EditText sID = findViewById(R.id.reg_studentID);
        EditText password = findViewById(R.id.regStudentPassword);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String studentName = sName.getText().toString();
               String studentID = sID.getText().toString();
               String studentPassword = password.getText().toString();
               if(studentName.isEmpty()) {
                   sName.requestFocus();
                   sName.setError("Please enter your name");
               }
               if(studentID.length()==0) {
                   sID.requestFocus();
                   sID.setError("Please enter your Student ID");
               }
               else if(studentID.length() < 8) {
                   sID.requestFocus();
                   sID.setError("Student ID must be 8 digits");
               }
               if(studentPassword.isEmpty()) {
                   password.requestFocus();
                   password.setError("Please set a password");
               }
               else if(studentPassword.length() < 6) {
                   password.requestFocus();
                   password.setError("Password must be at least 6 characters");
               }
               else {
                   Toast.makeText(register.this, "Registration successfully", Toast.LENGTH_SHORT).show();
               }
            }
        });
        TextView loginNow = findViewById(R.id.loginNow);
        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoLogin = new Intent(register.this, StudentLogin.class);
                startActivity(backtoLogin);
            }
        });
    }
}