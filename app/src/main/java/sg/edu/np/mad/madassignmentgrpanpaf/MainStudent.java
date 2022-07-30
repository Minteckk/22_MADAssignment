package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import sg.edu.np.mad.madassignmentgrpanpaf.databinding.ActivityMainStudentBinding;

public class MainStudent extends AppCompatActivity {

    private ActivityMainStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.studentViewFeedback, R.id.submitMCandAbsentReason)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_student);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        ImageView studentAttendance = findViewById(R.id.student_aimage);
        studentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainStudent.this,StudentTakeAttendance.class);
                startActivity(i);
            }
        });
        ImageView submitMC = findViewById(R.id.student_submitMC);
        submitMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MCintent = new Intent(MainStudent.this,SubmitMCandAbsentReason.class);
                startActivity(MCintent);
            }
        });
        ImageView readfeedback = findViewById(R.id.student_fimage);
        readfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedbackIntent = new Intent(MainStudent.this,StudentViewFeedback.class);
                startActivity(feedbackIntent);
            }
        });

        Button logout =  findViewById(R.id.button_logout3);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(MainStudent.this,MainActivity.class);
                startActivity(i);
            }
        });

        TextView studentID = findViewById(R.id.text_home);
        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "");
        studentID.setText("Hello S" + value);
    }

}