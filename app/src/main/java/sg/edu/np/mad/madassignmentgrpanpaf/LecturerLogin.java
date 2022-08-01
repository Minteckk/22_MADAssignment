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

public class LecturerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setView
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_login);

        // find the id for login button
        Button login_lec = findViewById(R.id.lecLogin);

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.lecturer_login_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //return to Role select page
                finish();
            }
        });

        //brings the user to the Register view
        TextView LecRegNow = findViewById(R.id.LecRegNow);
        LecRegNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LecturerLogin.this, LecturerRegister.class);
                startActivity(registerIntent);
            }
        });




        //start of new feature
        CheckBox enableBiometric;

        SharedPreferences preferences = getSharedPreferences("authentication", MODE_PRIVATE);
        String authentication = preferences.getString("login","");
        String role = preferences.getString("role","");
        if(authentication.equals("true") && role.equals("lecturer")){

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
                    Toast.makeText(LecturerLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(LecturerLogin.this, MainLecturer.class);
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
        enableBiometric = findViewById(R.id.lect_enable_biometric);

        enableBiometric.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences =
                            getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login", "1");
                    Toast.makeText(LecturerLogin.this, "Biometrics login enabled", Toast.LENGTH_SHORT).show();
                    editor.commit();
                }else{
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login","false");
                    Toast.makeText(LecturerLogin.this, "Biometrics login disabled", Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });
        //end of new feature

        // set Onclick listener for login button
        // goes to Lecturer Main page after the login button is clicked.
        login_lec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the inputted data from the login
                //get the elements for username and password
                EditText getLecUsername = findViewById(R.id.lecUsername);
                EditText getLecPassWord = findViewById(R.id.lecPW);

                String lecUsername = getLecUsername.getText().toString();
                String lecPassword = getLecPassWord.getText().toString();

                //if form data empty, display error msg
                if (lecUsername.length() == 0) {
                    getLecUsername.requestFocus();
                    getLecUsername.setError("Please enter your username");
                }
                else if (lecPassword.length() == 0) {
                    getLecPassWord.requestFocus();
                    getLecPassWord.setError("Please enter your password");
                } else if (lecPassword.length() < 6) {
                    getLecPassWord.setError("Your password must be more than 6 characters");
                } else {
                    Toast.makeText(LecturerLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // goes to Lecturer Main page after the login button is clicked.
                    Intent mainIntent = new Intent(LecturerLogin.this, MainLecturer.class);
                    // start of new feature
                    mainIntent.putExtra("Username", lecUsername);
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    String authentication = preferences.getString("login","");
                    if (authentication.equals("1")) {
                        editor.putString("login", "true");
                    }
                    //declare role of user
                    editor.putString("role", "lecturer");
                    editor.putString("username", lecUsername);
                    editor.putString("password", lecPassword);
                    editor.apply();
                    // end of new feature
                    startActivity(mainIntent);
                }
            }
        });
    }
    }