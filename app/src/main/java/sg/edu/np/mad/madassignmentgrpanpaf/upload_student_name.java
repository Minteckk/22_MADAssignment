package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class upload_student_name extends AppCompatActivity {
    // initialize the variables
    private Button uploadStudent;
    private EditText nameInput,idInput,classInput;
    // initialize the object
    students studentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_student_name);
        TextView lecname = findViewById(R.id.loginusername);
        Intent i = getIntent();
        String lecUsername = i.getStringExtra("Username");
        lecname.setText(lecUsername);

        // find the id of the name input and student id input field.
        nameInput = findViewById(R.id.studentName);
        idInput = findViewById(R.id.studentID);
        classInput = findViewById(R.id.studentClass);

        // find the id of the upload button
        uploadStudent =  findViewById(R.id.upload_student);

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.upload_student_name_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(upload_student_name.this, MainLecturer.class);
                i.putExtra("Username", lecUsername);
                startActivity(i);
            }
        });
        P01Handler studentDB = new P01Handler(this);
        // set on click event listener for the upload button
        uploadStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the name entered as a string.
                String name = nameInput.getText().toString();
                // get the studentID entered as a string
                String studentID = idInput.getText().toString();
                String studentClass = classInput.getText().toString();
                students student = new students(name, studentID,studentClass,true);
                //save data of User Name
                SharedPreferences.Editor editor = getSharedPreferences("StudentClass", MODE_PRIVATE).edit();
                editor.putString("KEY", studentClass);
                editor.apply();
                studentDB.addNewStudent(student);

                if(name.isEmpty()) {
                    nameInput.requestFocus();
                    nameInput.setError("Please enter your student name, name cannot empty");
                }
                else if(studentID.isEmpty())
                {
                    idInput.requestFocus();
                    idInput.setError("Student ID not be empty, please enter student id");
                }
                else if(!studentID.startsWith("1")) {
                    idInput.requestFocus();
                    idInput.setError("Student ID starts with 1, please enter a valid student id");
                }
                else if(studentID.length()<8) {
                    idInput.requestFocus();
                    idInput.setError("Student ID is less than 8 digits");
                }
                else if(studentClass.isEmpty()) {
                    classInput.requestFocus();
                    classInput.setError("Please enter a class");
                }

                else{
                    // toast message to let users to know that student is uploaded.
                    Toast.makeText(upload_student_name.this, "Student Uploaded!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(upload_student_name.this, uploadStudentConfirmation.class);
                    i.putExtra("name", name);
                    i.putExtra("studentid", studentID);
                    i.putExtra("class", studentClass);
                    startActivity(i);
                }
            }

       });
    }

}