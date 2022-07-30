package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class StudentAbsenceRecord extends AppCompatActivity {
    // global variable for absent arrayList
    ArrayList<absent> absenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_absence_record);

        // get Intent
        Intent i = getIntent();
        String lecUsername = i.getStringExtra("Username");

        // call the initialiseData method
        absenceList = initialiseData();
        // find the id of the recyclerView
        RecyclerView recyclerView = findViewById(R.id.rv2);
        // initialize Adapter
        AbsenceAdapter zAdapter = new AbsenceAdapter(absenceList);
        // initialize linearLayout
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        // set the layout manager and adapter
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(zAdapter);

        // SharedPreferences
        SharedPreferences prefs = 	getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "user");

        // onClickListener for backToMain button
        ImageView backToMain = findViewById(R.id.backToPrevious);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Lecturer Main Page
                Intent i = new Intent(StudentAbsenceRecord.this,MainLecturer.class);
                i.putExtra("Username",value);
                startActivity(i);
            }
        });
    }

    public ArrayList<absent> initialiseData() {
        // initialize db file and get the Activity
        AbsenceDBHandler db = new AbsenceDBHandler(this);
        ArrayList<absent> absenceList = db.getAbsentees();

        // return studentList
        return absenceList;
    }
}