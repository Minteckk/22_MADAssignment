package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_type);

        Button LecturerAccount = findViewById(R.id.reg_lecAccount);
        LecturerAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to the register page for user to register their account.
                Intent registerIntent = new Intent(RegistrationType.this,LecturerRegister.class);
                // start the activity
                startActivity(registerIntent);
            }
        });

        Button StudentAccount = findViewById(R.id.reg_student_acc);
        StudentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to the register page for user to register their account.
                Intent studentAcc = new Intent(RegistrationType.this,register.class);
                // start the activity
                startActivity(studentAcc);
            }
        });
    }
}