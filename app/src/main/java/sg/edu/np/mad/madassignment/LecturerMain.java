package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LecturerMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_main);

        // find the id of the imageview
        ImageView uploadStudentToDB = findViewById(R.id.db_student);
       // set the onClick listener for the imageview
        uploadStudentToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // goes to the upload student to database page
                Intent uploadIntent = new Intent(LecturerMain.this, upload_student_name.class);
                startActivity(uploadIntent);
            }
        });
    }
}