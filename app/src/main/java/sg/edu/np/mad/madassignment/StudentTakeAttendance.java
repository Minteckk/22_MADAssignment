package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
        String value = ((EditText) findViewById(R.id.student_aid)).getText().toString();
        int s_id=Integer.parseInt(value);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        if (s_passcode.equals(l_passcode)) {
            boolean i = true;
            AccountDBHandler.updateAttendance(s_id, date, i);
        } else {

        }
    }
}