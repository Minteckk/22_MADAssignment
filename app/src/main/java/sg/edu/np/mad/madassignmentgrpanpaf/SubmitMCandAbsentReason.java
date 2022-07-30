package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubmitMCandAbsentReason extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // the array list for Absent reason
String[] reasons = {"MC-Medical Certificate","Hospitalisation", "Compassionate Leave", "Medical Appointment at Hospital",
        "NS Related", "Participating in School/nation event", "Others"};
// the array list for Absent Type
String[] missedLesson = {"Lesson", "Class Test", "Common Test", "Exams", "Other Assements/Presentation", "Poly/CCA Event"};
    // get Calendar instance
    Calendar myCalendar= Calendar.getInstance();
   // global variables for the input fields, floatingActionButton, ImageView
    Bitmap selectedDocumentBitmap;
    EditText editText;
    EditText editText2;
    EditText editText3;
    FloatingActionButton upload;
    ImageView previewMC;
    DatePickerDialog datePicker;
    String selectedItem="";
    String selectedAbsenceType="";
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_mcand_absent_reason);
        // find the id for spinner
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        // find the id for input fields
        EditText clinicNo = findViewById(R.id.clinicNo);
        EditText clinicName = findViewById(R.id.clinicName);
        spin.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        // get Intent
        Intent i = new Intent();
        String studentId = i.getStringExtra("StudentID");

        // SharedPreferences
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "Student");

        // find the id for student id
        TextView studentID = findViewById(R.id.StudentidMC);
        // set the text as Student ID
        studentID.setText("S"+value);

        // find the id for the back button
        ImageView generate_back = findViewById(R.id.gen_back);

        // set the OnClickListener event listener for back button
        generate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to go back to the lecturer's main page.
                Intent i = new Intent(SubmitMCandAbsentReason.this, MainLecturer.class);
                i.putExtra("StudentID",value);
                // start the intent activity
                startActivity(i);
            }
        });

        // find the imageView for preview MC
        previewMC = findViewById(R.id.previewMC);

        // initialize DBHandler
        AbsenceDBHandler absenceDB = new AbsenceDBHandler(this);
        // find the id of Submit Button
        Button submitbtn = findViewById(R.id.submit);
        // new OnClickListener
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get Input fields to String
                String startDate = editText.getText().toString();
                String endDate = editText2.getText().toString();
                String DateOfIssue = editText3.getText().toString();
                String ClinicNo = clinicNo.getText().toString();
                String ClinicName = clinicName.getText().toString();
                // new absentees
                absent absentees = new absent(startDate,endDate,DateOfIssue,ClinicNo,ClinicName,value,selectedItem,selectedAbsenceType);
                // add new record to db
                absenceDB.addNewAbsentRecord(absentees);
                // input validation
                if(startDate.isEmpty()) {
                    editText.requestFocus();
                    editText.setError("Please select a start date");
                }
                else if(endDate.isEmpty()) {
                    editText2.requestFocus();
                    editText2.setError("Please select a end date");
                }
                else if(DateOfIssue.isEmpty()) {
                    editText3.requestFocus();
                    editText3.setError("Please enter the date of issue");
                }
                else if(ClinicNo.isEmpty()) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter the clinic number");
                } else if(clinicNo.length()<8) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter at least 8 digits");
                } else if(!ClinicNo.startsWith("6")) {
                    clinicNo.requestFocus();
                    clinicNo.setError("Please enter a telephone number that starts with 6");
                }
                else if(ClinicName.isEmpty()) {
                    clinicName.requestFocus();
                    clinicName.setError("Please enter the clinic name");
                }

                else {
                    // go to MCConfirmation page
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

        // new reason ArrayAdapter
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

        // new ArrayAdapter for absence from
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

        // DatePicker for StartDate
        editText = (EditText)  findViewById(R.id.startDate);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // set Calendar to current year,month, day
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                // call UpdateDate method
                updateDate();
            }
        };

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open DatePicker Dialog
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                // disable days that have passed
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });

        // find the id for endDate input field
        editText2 = (EditText)  findViewById(R.id.endDate);
        // new OnDateSet Listener
        DatePickerDialog.OnDateSetListener endDate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // set to current year and month and day
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                // call UpdateEndDate method
                updateEndDate();
            }
        };

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open DatePicker Dialog
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,endDate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                // disable dates that have passed
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });

        // find the id for date of Issue input
        editText3 = (EditText)  findViewById(R.id.dateofIssue);
        // new OnDateSetListener
        DatePickerDialog.OnDateSetListener issueDate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // get current year,month and day
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                myCalendar.setTimeInMillis(myCalendar.getTimeInMillis());
                // call updateIssueDate method
                updateIssueDate();
            }
        };
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open DatePicker Dialog
                datePicker = new DatePickerDialog(SubmitMCandAbsentReason.this,issueDate,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                // disable dates that have passed.
                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
                datePicker.show();
            }
        });

        // find the id for upload button
        upload = findViewById(R.id.addDoc);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call UploadMC method
                uploadMC();
            }
        });
    }

    // method to upload MC
    public void uploadMC() {
        // new intent
        Intent i = new Intent();
        // set the intent as image
        i.setType("image/*");
        // get content from the user to access their image gallery
        i.setAction(Intent.ACTION_GET_CONTENT);
        // launch the intent
        submitMCDocument.launch(i);
    }

    // new ActivityResult for uploading image
    ActivityResultLauncher<Intent> submitMCDocument = registerForActivityResult(new ActivityResultContracts.
                    StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent getData =  result.getData();
                        if(getData != null && getData.getData() != null) {
                            Uri selectedImageUri = getData.getData();
                            Bitmap B = selectedDocumentBitmap;
                            try {
                                selectedDocumentBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImageUri);
                            }
                            catch (IOException E)
                            {
                                E.printStackTrace();
                            }
                            previewMC.setImageBitmap(selectedDocumentBitmap);
                        }
                    }
            });


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Method for StartDate
    private void updateDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

    // Method for EndDate
    private void updateEndDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText2.setText(dateFormat.format(myCalendar.getTime()));
    }

    // Method for IssueDate
    private void updateIssueDate()
    {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText3.setText(dateFormat.format(myCalendar.getTime()));
    }
}