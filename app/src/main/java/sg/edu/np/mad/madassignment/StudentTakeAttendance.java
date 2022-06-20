package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentTakeAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_take_attendance);

    }


    public void compare(View view) {

        String l_passcode = ((TextView) findViewById(R.id.generated_pc)).getText().toString();
        String s_passcode = ((EditText) findViewById(R.id.student_acode)).getText().toString();
        P01Handler db = new P01Handler(this);

        if (s_passcode.equals(l_passcode)) {
            boolean i = true;
            students s = new students();

            s.AttendanceStatus = true;
            db.addNewStudent(s);
            Toast.makeText(getApplicationContext(),"Attendance updated!",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Invalid passcode entered",Toast.LENGTH_SHORT).show();
        }
    }
}