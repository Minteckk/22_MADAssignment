package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LecturerMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_main);

        TextView username = findViewById(R.id.lec_username);
        Intent i = getIntent();
        String lecUsername = i.getStringExtra("Username");
        username.setText(lecUsername);

        // find the id of the upload student to database img
        ImageView uploadStudentToDB = findViewById(R.id.db_student);

       // set the onClick listener for the imageview
        uploadStudentToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to the upload student to database page
                Intent uploadIntent = new Intent(LecturerMain.this, upload_student_name.class);
                startActivity(uploadIntent);
            }
        });

        // find the id of the view student attendance img
        ImageView view_student_attendance = findViewById(R.id.view_student_attendance);

        // set the onClick listener for the img
        view_student_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to the view student attendance page
                Intent uploadIntent = new Intent(LecturerMain.this, ViewAllStudentAttendance.class);
                startActivity(uploadIntent);
            }
        });

        // set the onClick listener for the logout button
        Button btn = findViewById(R.id.button_logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerMain.this, MainActivity.class);
                startActivity(i);
            }
        });

        // find the id of the view student image
        ImageView viewStudent = findViewById(R.id.studentView);
        // set the onClick listener for the image
        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to the view student page
                Intent viewIntent = new Intent(LecturerMain.this, ViewAllStudents.class);
                startActivity(viewIntent);
            }

        });

        // find the id of the generate passcode image
        ImageView generatePasscode = findViewById(R.id.passcodeImg);
        generatePasscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to generate passcode page
                Intent generateIntent = new Intent(LecturerMain.this, generatePassCode.class);
                startActivity(generateIntent);
            }
        });
    }
}