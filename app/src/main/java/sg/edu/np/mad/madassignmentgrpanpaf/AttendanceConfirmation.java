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
        Intent i = getIntent();
        String aID = i.getStringExtra("StudentID");
        TextView AttendanceID = findViewById(R.id.getAttendanceID);
        AttendanceID.setText(aID);
        String attendanceStatus = i.getStringExtra("status");
        TextView AttendanceStatus = findViewById(R.id.attendanceStatus);
        AttendanceStatus.setText(attendanceStatus);

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        Button backToMain = findViewById(R.id.BackToMain4);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AttendanceConfirmation.this, StudentMain.class);
                i.putExtra("StudentID",value);
                startActivity(i);
            }
        });
    }
}