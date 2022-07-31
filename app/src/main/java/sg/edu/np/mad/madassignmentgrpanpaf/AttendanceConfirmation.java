package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AttendanceConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_confirmation);
        // get Intent
        Intent i = getIntent();
        // get StudentID intent
        String aID = i.getStringExtra("StudentID");
        // find the id of the textView for StudentID
        TextView AttendanceID = findViewById(R.id.getAttendanceID);
        // set the text to the Student ID intent
        AttendanceID.setText(aID);
        // get Status intent
        String attendanceStatus = i.getStringExtra("status");
        // find the id for status
        TextView AttendanceStatus = findViewById(R.id.attendanceStatus);
        /// set the text to the Status intent
        AttendanceStatus.setText(attendanceStatus);

        // SharedPreferences to store the studentID
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        // Button onClickListener for back to Main button
        Button backToMain = findViewById(R.id.BackToMain4);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go back to student main page
                Intent i = new Intent(AttendanceConfirmation.this, MainStudent.class);
                // intent the studentID back to student main page
                i.putExtra("StudentID",value);
                startActivity(i);
            }
        });
    }
}