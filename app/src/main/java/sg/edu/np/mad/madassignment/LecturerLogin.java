package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LecturerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_login);
        // find the id for login button
        Button login_lec = findViewById(R.id.lecLogin);
        // set Onclick listener for login button
        login_lec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to Lecturer Main page after the login page is clicked.
                Intent mainIntent = new Intent(LecturerLogin.this, LecturerMain.class);
                startActivity(mainIntent);
            }
        });
    }
}