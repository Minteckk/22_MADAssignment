package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        // find the id for loginNow textview
        TextView backtoLecturerLogin = findViewById(R.id.loginNow2);
        // find the id for the input field
        EditText regLecName = findViewById(R.id.reg_staffName);
        EditText regLecID = findViewById(R.id.reg_StaffID);
        EditText regPassword = findViewById(R.id.reg_Password);
        // find the id for register button
        Button lecRegister = findViewById(R.id.registerBtn2);
        // set OnClickListener for the register button
        lecRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the input data and convert to String
                String lecturerName = regLecName.getText().toString();
                String lecturerID = regLecID.getText().toString();
                String lecturerPassword = regPassword.getText().toString();
                // if Name is empty, set Error
                if(lecturerName.isEmpty())
                {
                    regLecName.requestFocus();
                    regLecName.setError("Please enter your name");
                }
                // if lecturer ID is empty, set Error
                if(lecturerID.length() == 0) {
                    regLecID.requestFocus();
                    regLecID.setError("Please enter your staff id");
                }
                // if lecturer password is empty, set Error
                if(lecturerPassword.isEmpty()) {
                    regPassword.requestFocus();
                    regPassword.setError("Please set an password");
                }
                // if password is less than 6, set error
                else if(lecturerPassword.length() < 6) {
                    regPassword.requestFocus();
                    regPassword.setError("Password must be at least 6 characters");
                }
                else {
                    // show the toast message that lecturer registered successfully
                    Toast.makeText(LecturerRegister.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LecturerRegister.this,LecturerLogin.class);
                    startActivity(i);
                }
            }
        });
        // OnCLickListener for back button
        backtoLecturerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerRegister.this, LecturerLogin.class);
                startActivity(i);
            }
        });

    }
}