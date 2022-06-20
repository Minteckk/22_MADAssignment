package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LecturerRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_register);

        TextView backtoLecturerLogin = findViewById(R.id.loginNow2);
        backtoLecturerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LecturerRegister.this, LecturerLogin.class);
                startActivity(i);
            }
        });
    }
}