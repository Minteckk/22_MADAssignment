package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        String loginName = i.getStringExtra("username");

        SharedPreferences.Editor editor = 	getSharedPreferences("UsernameSP", MODE_PRIVATE).edit();
        editor.putString("Username", lecUsername);
        editor.apply();

        SharedPreferences prefs = 	getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");



        // find the id of the upload student to database img
        ImageView uploadStudentToDB = findViewById(R.id.db_student);

       // set the onClick listener for the imageview
        uploadStudentToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to the upload student to database page
                Intent uploadIntent = new Intent(LecturerMain.this, upload_student_name.class);
                uploadIntent.putExtra("Username",value);
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
                uploadIntent.putExtra("Username",value);
                startActivity(uploadIntent);
            }
       });

        // set the onClick listener for the logout button
        Button btn = findViewById(R.id.button_logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerMain.this, MainActivity.class);
                // Close all activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Add a new flag to start new activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
                viewIntent.putExtra("Username",value);
                startActivity(viewIntent);
            }

        });

        // find the id of the generate passcode image
        ImageView generatePasscode = findViewById(R.id.qrcodeimg);
        generatePasscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to generate passcode page
                Intent generateIntent = new Intent(LecturerMain.this, generatePassCode.class);
                generateIntent.putExtra("Username",value);
                startActivity(generateIntent);
            }
        });

        ImageView absenceRecord = findViewById(R.id.absentimg);
        absenceRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent absent = new Intent(LecturerMain.this, StudentAbsenceRecord.class);
                absent.putExtra("Username",value);
                startActivity(absent);
            }
        });
    }
}