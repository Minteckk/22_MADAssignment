package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class upload_student_name extends AppCompatActivity {
    // initialize the variables
    private Button uploadStudent;
    private EditText nameInput,idInput;
    // initialize the object
    students studentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_student_name);
        // find the id of the name input and student id input field.
        nameInput = findViewById(R.id.studentName);
        idInput = findViewById(R.id.studentID);
        // get the database references
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // get the path of the database reference.
        DatabaseReference studentRef = database.getReference("Students");
        // create student-details as the child of students.
        DatabaseReference students = studentRef.child("Student-Details").push();
        // get the reference for student-details path
        DatabaseReference studentRef2 = database.getReference("Student-Details");
        // create StudentId as the child of students.
        DatabaseReference studentIdRef = studentRef2.child("StudentId:").push();
        // create StudentName as the child of students.
        DatabaseReference studentNameRef = studentRef2.child("StudentName").push();
        // create a new object - call studentInfo
        studentInfo = new students();
        // find the id of the upload button
        uploadStudent =  findViewById(R.id.upload_student);

        // set Onclick listener for back image view
        ImageView iv = findViewById(R.id.upload_student_name_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(upload_student_name.this, LecturerMain.class);
                startActivity(i);
            }
        });

        // set on click event listener for the upload button
        uploadStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the name entered as a string.
                String name = nameInput.getText().toString();
                // get the studentID entered as a string
                String studentID = idInput.getText().toString();
                // add a value event listener to studentID.
                studentIdRef.child("StudentId:").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                          // check if the input field is empty. if empty, a toast message will appear.
                        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(studentID)) {
                            // toast message to inform user to input a name and id.
                            Toast.makeText(upload_student_name.this,
                                    "Please enter student name and id to upload the student to database",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            // call the newStudent method.
                            newStudent(name,studentID);
                            // get the value of the snapshot
                            snapshot.getChildren();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // log error message
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
                // add a value event listener to StudentName
                studentRef2.child("StudentName:").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // get the value of the snapshot
                        snapshot.getChildren();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // log error message
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
            }
            // method to set the value of the studentID and name.
            private void newStudent (String name, String studentID)
            {
                // set the studentID as the value entered in the input field.
                studentInfo.SetStudentID(studentID);
                // set the Name as the value entered in the input field.
                studentInfo.setName(name);
                // add a value event listener to students.
                studentRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // set the student values as the studentInfo obtained.
                        studentNameRef.setValue(studentInfo);
                        // toast message to let users to know that student is uploaded.
                        Toast.makeText(upload_student_name.this, "Student Uploaded!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // toast message to let users to know that the upload is not successful.
                        Toast.makeText(upload_student_name.this, "Student Upload Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

}