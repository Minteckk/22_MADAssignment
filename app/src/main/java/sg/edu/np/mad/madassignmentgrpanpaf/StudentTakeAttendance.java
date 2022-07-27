package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class StudentTakeAttendance extends AppCompatActivity {
    String value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_take_attendance);

        // get intent
        Intent i = new Intent();
        // get studentId from previous page
        String studentId = i.getStringExtra("StudentID");

        // SharedPreferences
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        value2 = prefs.getString("StudentID", "Student");

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_take_attendance_back);
        // set OnClickListener
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Student Main Page
                finish();
            }
        });


    }


    public void compare(View view) {
        // get Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("passcode",MODE_PRIVATE);
        // get Shared Preferences value
        String value = sharedPreferences.getString("code","");
        // get the code entered by student and convert to string.
        String s_passcode = ((EditText) findViewById(R.id.student_acode)).getText().toString();
        // call DB Handler
        P01Handler db = new P01Handler(this);
        // if no code is entered, toast message "Invalid passcode entered"
        if (s_passcode.isEmpty() == true) {
            Toast.makeText(getApplicationContext(),"Invalid passcode entered",Toast.LENGTH_SHORT).show();
        }
        // if code entered matches the pass code given by lecturer, set Attendance Status to true and update student
        // attendance
        else if (s_passcode.equals(value)) {
            boolean i = true;
            //students s = new students();
            String Attendance_status = "Present";
            db.updateAttendance(value2, Attendance_status);
            Toast.makeText(getApplicationContext(),"Attendance updated!",Toast.LENGTH_SHORT).show();
            Intent attendanceConfirm = new Intent(StudentTakeAttendance.this, AttendanceConfirmation.class);
            attendanceConfirm.putExtra("StudentID",value2);
            attendanceConfirm.putExtra("status",Attendance_status);
            startActivity(attendanceConfirm);
        } else {
            Toast.makeText(getApplicationContext(),"Invalid passcode entered",Toast.LENGTH_SHORT).show();
        }
    }
}