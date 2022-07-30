package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mcConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_confirmation);

        // find the id for submitDateTime TextView
        TextView submitTime = findViewById(R.id.submitDateTime);
        // Set Date Format
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // set the TextView to display the currentDateTime
        submitTime.setText(currentDateTime);

        // find the id for startDate Textview
        TextView startDate = findViewById(R.id.getStartDate);
        // get Intent
        Intent i = getIntent();
        // get Start Date from submit mc and absent reason page
        String getStartDate = i.getStringExtra("StartDate");
        // set the startDate TextView
        startDate.setText(getStartDate);
        // find the id for endDate TextView
        TextView endDate = findViewById(R.id.getEndDate);
        // get End Date from submit mc and absent reason page
        String getEndDate = i.getStringExtra("endDate");
        // set the endDate TextView
        endDate.setText(getEndDate);
        // find the id for reason TextView
        TextView reason = findViewById(R.id.reason);
        // get the absent reason from previous page
        String absReason = i.getStringExtra("position");
        // set the absence reason textview text
        reason.setText(absReason);
        // find the id for the absence type textview
        TextView absenceType = findViewById(R.id.absenceFrom);
        // get the absent type from previous page
        String absType = i.getStringExtra("Absencefrom");
        // set the text for the absent type
        absenceType.setText(absType);
        // find the id of Clinic Number TextView
        TextView clinicNumber = findViewById(R.id.clinic);
        // get the clinic Number from previous page
        String clinic = i.getStringExtra("ClinicNo");
        // set the text for the clinic number
        clinicNumber.setText(clinic);
        // find the id for date of Issue
        TextView dateOfIssue =  findViewById(R.id.dateOfIssue);
        // get the Date Of Issue from previous page
        String DOI = i.getStringExtra("dateOfIssue");
        // set Date of Issue TextView
        dateOfIssue.setText(DOI);
        // find the id of clinic Name TextView
        TextView tv = findViewById(R.id.getclinicName);
        // get Clinic Name from previous page
        String clinicName = i.getStringExtra("ClinicName");
        // set clinic name TextView
        tv.setText(clinicName);

        // SharedPreferences
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        // find the textview for studentID
        TextView studentID = findViewById(R.id.confirm_id);
        // get the studentID from the sharedPreferences value
        studentID.setText("S"+value);

        // back to main button event listener
        Button backToMain = findViewById(R.id.backtomain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to student main page
                Intent i = new Intent(mcConfirmation.this, StudentMain.class);
                i.putExtra("StudentID",value);
                startActivity(i);
            }
        });
    }
}