package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

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

        //start of new feature
        CheckBox enableBiometric;

        SharedPreferences preferences = getSharedPreferences("authentication", MODE_PRIVATE);
        String authentication = preferences.getString("login","");
        String role = preferences.getString("role","");
        if(authentication.equals("true") && role.equals("student")){

            BiometricPrompt biometricPrompt;
            BiometricPrompt.PromptInfo promptInfo;

            BiometricManager biometricManager = BiometricManager.from(this);
            switch (biometricManager.canAuthenticate()){
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(getApplicationContext(),"Device does not have biometric hardware",Toast.LENGTH_SHORT).show();
                    break;

                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(getApplicationContext(),"Biometric hardware is not available",Toast.LENGTH_SHORT).show();

                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(getApplicationContext(),"No biometric saved",Toast.LENGTH_SHORT).show();

            }

            Executor executor = ContextCompat.getMainExecutor(this);

            biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    //Login Success
                    Toast.makeText(StudentLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(StudentLogin.this, StudentMain.class);
                    mainIntent.putExtra("Username", preferences.getString("username",""));
                    startActivity(mainIntent);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("NPAF")
                    .setDescription("Use Biometrics to login").setDeviceCredentialAllowed(true).build();

            biometricPrompt.authenticate(promptInfo);


        }else{
            Toast.makeText(this, "Please login", Toast.LENGTH_SHORT).show();
        }
        enableBiometric = findViewById(R.id.std_enable_biometric);

        enableBiometric.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences =
                            getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login", "1");
                    Toast.makeText(StudentLogin.this, "Biometric login enabled", Toast.LENGTH_SHORT).show();
                    editor.commit();
                }else{
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login","false");
                    Toast.makeText(StudentLogin.this, "Biometrics login disabled", Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });
        //end of new feature

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
                    // start of new feature
                    intent.putExtra("StudentID",studentID);
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    String authentication = preferences.getString("login","");
                    if (authentication.equals("1")) {
                        editor.putString("login", "true");
                    }
                    //declare role of user
                    editor.putString("role", "student");
                    editor.putString("username", studentID);
                    editor.putString("password", studentPassword);
                    editor.apply();
                    // end of new feature
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