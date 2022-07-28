package sg.edu.np.mad.madassignmentgrpanpaf;
import androidx.appcompat.app.AppCompatActivity;

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

public class LecturerLogin extends AppCompatActivity {

    CheckBox enableBiometric;

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


        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        String authentication = preferences.getString("login","");
        if(authentication.equals("true")){

            Toast.makeText(LecturerLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent mainIntent = new Intent(LecturerLogin.this, LecturerMain.class);
            mainIntent.putExtra("Username", preferences.getString("username",""));
            startActivity(mainIntent);
        }else{
            Toast.makeText(this, "Biometric login was disabled.", Toast.LENGTH_SHORT).show();
        }
        enableBiometric = findViewById(R.id.lect_enable_biometric);

        enableBiometric.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login", "true");
                    editor.apply();
                }else{
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login","false");
                    editor.apply();
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
                    Intent mainIntent = new Intent(LecturerLogin.this, LecturerMain.class);
                    mainIntent.putExtra("Username", lecUsername);
                    SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login", "true");
                    editor.putString("username", lecUsername);
                    editor.putString("password", lecPassword);
                    editor.apply();
                    startActivity(mainIntent);
                }
            }
        });
    }
    }