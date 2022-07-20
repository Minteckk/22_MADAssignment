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
        Intent i =  getIntent();
        String sName = i.getStringExtra("name");
        String sID = i.getStringExtra("studentid");
        String sClass = i.getStringExtra("class");
        TextView getSName = findViewById(R.id.upload_sName);
        getSName.setText(sName);
        TextView getSID = findViewById(R.id.upload_sID);
        getSID.setText(sID);
        TextView getSClass = findViewById(R.id.upload_SClass);
        getSClass.setText(sClass);

        SharedPreferences prefs = getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(uploadStudentConfirmation.this,LecturerMain.class);
                i.putExtra("Username",value);
                startActivity(i);
            }
        });
    }
}