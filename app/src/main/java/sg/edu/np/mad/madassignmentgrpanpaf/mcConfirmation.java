package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class mcConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_confirmation);

        TextView submitTime = findViewById(R.id.submitDateTime);
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //Date currentTime = Calendar.getInstance().getTime();
        submitTime.setText(currentDateTime);

        TextView startDate = findViewById(R.id.getStartDate);
        Intent i = getIntent();
        String getStartDate = i.getStringExtra("StartDate");
        startDate.setText(getStartDate);
        TextView endDate = findViewById(R.id.getEndDate);
        String getEndDate = i.getStringExtra("endDate");
        endDate.setText(getEndDate);
        TextView reason = findViewById(R.id.reason);
        //int positionToShowToSpinner = i.getIntExtra("position", 0);
        String absReason = i.getStringExtra("position");
        reason.setText(absReason);
        TextView absenceType = findViewById(R.id.absenceFrom);
        String absType = i.getStringExtra("Absencefrom");
        absenceType.setText(absType);
        TextView clinicNumber = findViewById(R.id.clinic);
        String clinic = i.getStringExtra("ClinicNo");
        clinicNumber.setText(clinic);
        TextView dateOfIssue =  findViewById(R.id.dateOfIssue);
        String DOI = i.getStringExtra("dateOfIssue");
        dateOfIssue.setText(DOI);
        TextView tv = findViewById(R.id.getclinicName);
        String clinicName = i.getStringExtra("ClinicName");
        tv.setText(clinicName);

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        TextView studentID = findViewById(R.id.confirm_id);
        studentID.setText("S"+value);

        //spin.setSelection(positionToShowToSpinner);

        Button backToMain = findViewById(R.id.backtomain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcConfirmation.this,StudentMain.class);
                i.putExtra("StudentID",value);
                startActivity(i);
            }
        });
    }
}