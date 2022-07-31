package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class uploadStudentConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_student_confirmation);
        // get Intent
        Intent i =  getIntent();
        // get StudentName, Student ID, StudentClass from previous page
        String sName = i.getStringExtra("name");
        String sID = i.getStringExtra("studentid");
        String sClass = i.getStringExtra("class");
        TextView getSName = findViewById(R.id.upload_sName);
        // set the Student Name
        getSName.setText(sName);
        TextView getSID = findViewById(R.id.upload_sID);
        // set the Student ID
        getSID.setText(sID);
        TextView getSClass = findViewById(R.id.upload_SClass);
        // set the Student Class
        getSClass.setText(sClass);

        // SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");

        // button EventListener for back to main
        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Lecturer Main page
                Intent i = new Intent(uploadStudentConfirmation.this,MainLecturer.class);
                i.putExtra("Username",value);
                startActivity(i);
            }
        });
    }
}