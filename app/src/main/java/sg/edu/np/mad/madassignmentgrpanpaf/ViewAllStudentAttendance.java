package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ViewAllStudentAttendance extends AppCompatActivity {
    // initalize
    public ArrayList<students> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        // find the id for the display Username textView
        TextView lecname = findViewById(R.id.loginusernamedisplay);
        // get intent
        Intent i = getIntent();
        // receiving the username intent
        String lecUsername = i.getStringExtra("Username");
        // set the text to username
        lecname.setText(lecUsername);

        // find the id for the back button
        ImageView iv = findViewById(R.id.view_all_students_back);
        // set OnClickListener
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start the intent to go to Lecturer Main Page
                Intent i = new Intent(ViewAllStudentAttendance.this, LecturerMain.class);
                // send the username back to Lecturer Main Page
                i.putExtra("Username",lecUsername);
                // start the activity.
                startActivity(i);
            }
        });

        // find the id for P01 button
       Button P01Class = findViewById(R.id.P01);
       // set OnClickListener
       P01Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // start the fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentAttendanceP01 fragment1 = StudentAttendanceP01.newInstance("P01","P02");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });

       // find the id for P02 button
       Button P02Class = findViewById(R.id.P02);
       // set OnClickListener
       P02Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // start the fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentAttendanceP02 fragment1 = StudentAttendanceP02.newInstance("P02","P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });

       // find the id for P03 button
       Button P03Class = findViewById(R.id.P03);
       // set OnClickListener
       P03Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // start the fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               // new Instance of fragment
               StudentAttendanceP03 fragment1 = StudentAttendanceP03.newInstance("P03", "P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });

       // find the id for P04 button
        Button P04Class = findViewById(R.id.P04);
        // set OnClickListener
        P04Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start fragment
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentAttendanceP04 fragment1 = StudentAttendanceP04.newInstance("P04", "P05");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });

        // find the id for P05 button
        Button P05Class = findViewById(R.id.P05);
        // set OnClickListener
        P05Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start fragment
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentAttendanceP05 fragment1 = StudentAttendanceP05.newInstance("P05", "P06");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });
    }
}

