package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;

public class SubmitMCandAbsentReason extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
String[] reasons = {"MC-Medical Certificate","Hospitalisation", "Compassionate Leave", "Medical Appointment at Hospital",
        "NS Related", "Participating in School/nation event", "Others"};
String[] missedLesson = {"Lesson", "Class Test", "Common Test", "Exams", "Other Assements/Presentation", "Poly/CCA Event"};
    Calendar myCalendar= Calendar.getInstance();
    EditText editText;
    EditText editText2;
    EditText editText3;
    DatePickerDialog datePicker;
    int positionOfSelectedDataFromSpinner;
    String selectedItem="";
    String selectedAbsenceType="";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_mcand_absent_reason);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        EditText clinicNo = findViewById(R.id.clinicNo);
        EditText clinicName = findViewById(R.id.clinicName);
        spin.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        Intent i = new Intent();
        String studentId = i.getStringExtra("StudentID");

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        TextView studentID = findViewById(R.id.StudentidMC);
        studentID.setText("S"+value);

        // find the id for the back button
        ImageView generate_back = findViewById(R.id.gen_back);

        // set the OnClickListener event listener for back button
        generate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to go back to the lecturer's main page.
                Intent i = new Intent(SubmitMCandAbsentReason.this, StudentMain.class);
                i.putExtra("StudentID",value);
                // start the intent activity
                startActivity(i);
            }
        });

        Button submitbtn = findViewById(R.id.submit);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startDate = editText.getText().toString();
                String endDate = editText2.getText().toString();
                String DateOfIssue = editText3.getText().toString();
                String ClinicNo = clinicNo.getText().toString();
                String ClinicName = clinicName.getText().toString();
                if(startDate.isEmpty()) {
                    editText.requestFocus();
                    editText.setError("Please select a start date");
                }
                if(endDate.isEmpty()) {
                    editText2.requestFocus();
                    editText2.setError("Please select a end date");
                }
                if(DateOfIssue.isEmpty()) {
                    editText3.requestFocus();
                    editText3.setError("Please enter the date of issue");
                }
                if(ClinicNo.isEmpty()) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter the clinic number");
                } else if(clinicNo.length()<8) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter at least 8 digits");
                } else if(!ClinicNo.startsWith("6")) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter a telephone number that starts with 6");
                }
                if(ClinicName.isEmpty()) {
                    clinicName.requestFocus();
                    clinicName.setError("Please enter the clinic name");
                }

                else {
                    Intent confirmation = new Intent(SubmitMCandAbsentReason.this,mcConfirmation.class);
                    confirmation.putExtra("StartDate",startDate);
                    confirmation.putExtra("endDate", endDate);
                    confirmation.putExtra("position",selectedItem);
                    confirmation.putExtra("Absencefrom", selectedAbsenceType);
                    confirmation.putExtra("ClinicNo",ClinicNo);
                    confirmation.putExtra("dateOfIssue",DateOfIssue);
                    confirmation.putExtra("StudentID",value);
                    confirmation.putExtra("ClinicName",ClinicName);
                    startActivity(confirmation);
                }

            }
        });

        ArrayAdapter reason = new ArrayAdapter(this,android.R.layout.simple_spinner_item,reasons);
        reason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(reason);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem=spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter missedType = new ArrayAdapter(this,android.R.layout.simple_spinner_item,missedLesson);
        missedType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(missedType);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedAbsenceType=spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editText = (EditText)  findViewById(R.id.startDate);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                updateDate();
            }
        };
        //datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });

        editText2 = (EditText)  findViewById(R.id.endDate);
        DatePickerDialog.OnDateSetListener endDate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                updateEndDate();
            }
        };
        //datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,endDate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });

        editText3 = (EditText)  findViewById(R.id.dateofIssue);
        DatePickerDialog.OnDateSetListener issueDate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                updateIssueDate();
            }
        };
        //datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this);
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,issueDate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(getApplicationContext(),reasons[position] , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void updateDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateEndDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText2.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateIssueDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText3.setText(dateFormat.format(myCalendar.getTime()));
    }


}