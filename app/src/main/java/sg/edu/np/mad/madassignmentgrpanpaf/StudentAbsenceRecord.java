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
    ArrayList<absent> absenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_absence_record);

        Intent i = getIntent();
        String lecUsername = i.getStringExtra("Username");

        absenceList = initialiseData();
        RecyclerView recyclerView = findViewById(R.id.rv2);
        AbsenceAdapter zAdapter = new AbsenceAdapter(absenceList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(zAdapter);

        SharedPreferences prefs = 	getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username", "user");

        ImageView backToMain = findViewById(R.id.backToPrevious);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentAbsenceRecord.this,LecturerMain.class);
                i.putExtra("Username",value);
                startActivity(i);
            }
        });
    }

    public ArrayList<absent> initialiseData() {
        // initialize list
        //ArrayList<String> nameList = new ArrayList<String>();
        //ArrayList<Integer> idList = new ArrayList<Integer>();
        //Random random = new Random();
        // initialize db file and get the Activity
        AbsenceDBHandler db = new AbsenceDBHandler(this);
        // set the studentList to get students from the db file
        //SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        //String value = prefs.getString("StudentID", studentId);
        //ArrayList<attendance> feedbackList = db.FindFeedbackByStudentID(value);
        ArrayList<absent> absenceList = db.getAbsentees();

        // return studentList
        return absenceList;
    }
}