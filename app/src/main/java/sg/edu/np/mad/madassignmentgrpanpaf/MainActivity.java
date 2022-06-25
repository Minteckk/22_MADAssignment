package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the id of the get Started button
        Button getStarted = findViewById(R.id.getStartedBtn);
        // set the onClickListener for getStarted button
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to the user role page for user to select if they are a student or teacher.
                Intent roleIntent = new Intent(MainActivity.this,UserRole.class);
                // start the activity
                startActivity(roleIntent);
            }
        });
    }
}