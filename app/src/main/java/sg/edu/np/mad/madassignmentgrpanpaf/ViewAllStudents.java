package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAllStudents extends AppCompatActivity {
    // initialize
    public ArrayList<students> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        // find the id for the display username TextView
        TextView lecname = findViewById(R.id.loginusernamedisplay);
        // get intent
        Intent i = getIntent();
        // receiving the username intent
        String lecUsername = i.getStringExtra("Username");
        // set textView text to username
        lecname.setText(lecUsername);
        SharedPreferences prefs = getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "Lecturer");


        // find the id for the back button
        ImageView iv = findViewById(R.id.view_all_students_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get intent
                Intent i = new Intent(ViewAllStudents.this, MainLecturer.class);
                // intent to send username to other activity.
                i.putExtra("Username", lecUsername);
                // start activity
                startActivity(i);
            }
        });

        // find the id for P01 button
       Button P01Class = findViewById(R.id.P01);
       // set OnClickListener
       P01Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // start fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentP01 fragment1 = StudentP01.newInstance("P01","P02");
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
               // start fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentP02 fragment1 = StudentP02.newInstance("P02","P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });

       // find the id for the P03 button
       Button P03Class = findViewById(R.id.P03);
       // set OnClickListener
       P03Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // start fragment
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentP03 fragment1 = StudentP03.newInstance("P03", "P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });

       // find the id for the P04 button
        Button P04Class = findViewById(R.id.P04);
        // set OnClickListener
        P04Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start fragment
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentP04 fragment1 = StudentP04.newInstance("P04", "P05");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });

        // find the id for the P05 button
        Button P05Class = findViewById(R.id.P05);
        // set OnClickListener
        P05Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start fragment
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentP05 fragment1 = StudentP05.newInstance("Group5", "P05");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });
    }
}

