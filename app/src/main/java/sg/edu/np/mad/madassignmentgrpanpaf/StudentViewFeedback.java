package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class StudentViewFeedback extends AppCompatActivity {
    String studentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_feedback);

        ArrayList<attendance> feedbackList;

        Intent i = new Intent();
        studentId = i.getStringExtra("StudentID");
        //String studentName  = i.getStringExtra("StudentName");
        //String value = prefs.getString("KEY",studentName);
        //getStudentID.setText(value);
        //getStudentID.setText("S"+studentId);

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "");

        //P01Handler db = new P01Handler(this);
        //ArrayList<attendance> feedbackListAll = db.getFeedback();
        feedbackList = initialiseData();
        RecyclerView recyclerView = findViewById(R.id.rv);
        feedbackAdapter mAdapter = new feedbackAdapter(feedbackList,getApplicationContext());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);




        // initialize attendance object
        //attendance feedback = new attendance();
        // get Feedback from attendance object
        //String SFB = feedback.getFeedback();
        // find the textview by id
        //TextView fb = findViewById(R.id.student_view_feedback_feedback);
        // set the TextView text to the feedback
        //fb.setText(SFB);
        // get the text of the textview and convert to string
        //String fbstring = fb.getText().toString();

        // if the string is empty, set the text to No feedback given
        //if (fbstring.isEmpty() == true) {
            //fb.setText("No feedbacks given.");
        //}


        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.student_view_feedback_back);
        // set OnClickListener
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to Student Main Page
                Intent i = new Intent(StudentViewFeedback.this, StudentMain.class);
                i.putExtra("StudentID",value);
                // start activity
                startActivity(i);
            }
        });
    }

    public ArrayList<attendance> initialiseData() {
        // initialize list
        //ArrayList<String> nameList = new ArrayList<String>();
        //ArrayList<Integer> idList = new ArrayList<Integer>();
        //Random random = new Random();
        // initialize db file and get the Activity
        P01Handler db = new P01Handler(this);
        // set the studentList to get students from the db file
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", studentId);
        //ArrayList<attendance> feedbackList = db.FindFeedbackByStudentID(value);
        ArrayList<attendance> feedbackList = db.FindFeedbackByStudentID(value);


        //students student = db.findStudentClass(value);

        // return studentList
        return feedbackList;
    }
}