package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        // set Onclick listener for login button
        login_lec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountDBHandler dbHandler = new AccountDBHandler(LecturerLogin.this, null, null, 1);
                String staffIdString = usernameBox.getText().toString();
                String password = passwordBox.getText().toString();
                int staffId = -1;
                if (!staffIdString.equals("")) {
                    staffId = Integer.parseInt(staffIdString);
                    passwordBox.setText("");
                    usernameBox.setText("");
                    //Toast.makeText(LecturerLogin.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                }

                if (dbHandler.checkStaffPassword(staffId, password)){
                    Intent mainIntent = new Intent(LecturerLogin.this, LecturerMain.class);
                    startActivity(mainIntent);
                }
                else{
                    Toast.makeText(LecturerLogin.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}