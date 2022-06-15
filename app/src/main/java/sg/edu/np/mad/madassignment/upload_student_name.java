package sg.edu.np.mad.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class upload_student_name extends AppCompatActivity {
    private Button uploadStudent;
    private EditText nameInput,idInput;
    students studentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_student_name);

        nameInput = findViewById(R.id.studentName);
        idInput = findViewById(R.id.studentID);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference studentRef = database.getReference("Students");
        DatabaseReference students = studentRef.child("Student-Details").push();
        DatabaseReference studentRef2 = database.getReference("Student-Details");
        DatabaseReference studentIdRef = studentRef2.child("StudentId:").push();
        DatabaseReference studentNameRef = studentRef2.child("StudentName").push();

        studentInfo = new students();
        uploadStudent =  findViewById(R.id.upload_student);
        uploadStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String studentID = idInput.getText().toString();
                studentIdRef.child("StudentId:").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(studentID)) {
                            Toast.makeText(upload_student_name.this,
                                    "Please enter student name and id to upload the student to database",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            newStudent(name,studentID);
                            snapshot.getChildren();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                studentRef2.child("StudentName:").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        snapshot.getChildren();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
            }
            private void newStudent (String name, String studentID)
            {
                studentInfo.SetStudentID(studentID);
                studentInfo.setName(name);

                studentRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        studentNameRef.setValue(studentInfo);
                        Toast.makeText(upload_student_name.this, "Student Uploaded!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(upload_student_name.this, "Student Upload Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

}