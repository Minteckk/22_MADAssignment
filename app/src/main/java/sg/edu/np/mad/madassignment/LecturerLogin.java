package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LecturerLogin extends AppCompatActivity {

    TextView accessView;
    EditText usernameBox;
    EditText passwordBox;

    Button login_lec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_login);

        accessView = (TextView) findViewById(R.id.lecAccess);
        usernameBox = (EditText) findViewById(R.id.lecUsername);
        passwordBox = (EditText) findViewById(R.id.lecPW);


        // find the id for login button
        login_lec = findViewById(R.id.lecLogin);

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.lecturer_login_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerLogin.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void staffLogin(View view){

        AccountDBHandler dbHandler = new AccountDBHandler(this, null, null, 1);
        int staffId = Integer.parseInt(usernameBox.getText().toString());
        String password = passwordBox.getText().toString();
        usernameBox.setText("");
        passwordBox.setText("");

        if (dbHandler.checkStaffPassword(staffId, password)){
                    Intent mainIntent = new Intent(LecturerLogin.this, LecturerMain.class);
                    startActivity(mainIntent);
        }
        else{
            accessView.setText("Invalid Username or Password!");
        }
    }
}