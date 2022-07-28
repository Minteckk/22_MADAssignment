package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class PersonaliseStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise_lecturer);

        // get Intent
        Intent i = getIntent();
        // get Lecturer Name from Lecturer Login
        String lecUsername = i.getStringExtra("Username");

        // Shared Preferences
        SharedPreferences.Editor editor = 	getSharedPreferences("UsernameSP", MODE_PRIVATE).edit();
        editor.putString("Username", lecUsername);
        editor.apply();

        SharedPreferences prefs = 	getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");
    }
}