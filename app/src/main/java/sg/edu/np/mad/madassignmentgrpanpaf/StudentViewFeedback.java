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

public class StudentViewFeedback extends AppCompatActivity {
    String studentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_feedback);

        ArrayList<attendance> feedbackList;

        Intent i = new Intent();
        studentId = i.getStringExtra("StudentID");


        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "");

        feedbackList = initialiseData();
        RecyclerView recyclerView = findViewById(R.id.rv);
        feedbackAdapter mAdapter = new feedbackAdapter(feedbackList,getApplicationContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);


        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_view_feedback_back);
        // set OnClickListener
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Student Main Page
                Intent i = new Intent(StudentViewFeedback.this, MainStudent.class);
                i.putExtra("StudentID",value);
                // start activity
                startActivity(i);
            }
        });
    }

    public ArrayList<attendance> initialiseData() {
        // initialize list
        // initialize db file and get the Activity
        P01Handler db = new P01Handler(this);
        // set the studentList to get students from the db file
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", studentId);
        ArrayList<attendance> feedbackList = db.FindFeedbackByStudentID(value);

        // return studentList
        return feedbackList;
    }
}