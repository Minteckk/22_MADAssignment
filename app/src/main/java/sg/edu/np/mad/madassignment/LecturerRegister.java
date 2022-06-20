package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LecturerRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_register);

        TextView backtoLecturerLogin = findViewById(R.id.loginNow2);
        EditText regLecName = findViewById(R.id.reg_staffName);
        EditText regLecID = findViewById(R.id.reg_StaffID);
        EditText regPassword = findViewById(R.id.reg_Password);
        Button lecRegister = findViewById(R.id.registerBtn2);
        lecRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lecturerName = regLecName.getText().toString();
                String lecturerID = regLecID.getText().toString();
                String lecturerPassword = regPassword.getText().toString();
                if(lecturerName.isEmpty())
                {
                    regLecName.requestFocus();
                    regLecName.setError("Please enter your name");
                }
                if(lecturerID.length() == 0) {
                    regLecID.requestFocus();
                    regLecID.setError("Please enter your staff id");
                }
                if(lecturerPassword.isEmpty()) {
                    regPassword.requestFocus();
                    regPassword.setError("Please set an password");
                }
                else if(lecturerPassword.length() < 6) {
                    regPassword.requestFocus();
                    regPassword.setError("Password must be at least 6 characters");
                }
                else {
                    Toast.makeText(LecturerRegister.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backtoLecturerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerRegister.this, LecturerLogin.class);
                startActivity(i);
            }
        });

    }
}