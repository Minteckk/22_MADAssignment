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
                SharedPreferences preferences = getSharedPreferences("authentication",MODE_PRIVATE);
                if (preferences.getString("role", "").equals("student")) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("login", "false");
                    editor.apply();
                }

                Intent i = new Intent(MainStudent.this,MainActivity.class);
                // Close all activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Add a new flag to start new activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        Button s_location =  findViewById(R.id.s_location);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lo_s = new Intent(MainStudent.this,student_location.class);
                startActivity(lo_s);
            }
        });

        TextView studentID = findViewById(R.id.text_home);
        Intent i = getIntent();

        String studentId = i.getStringExtra("StudentID");
        studentID.setText("Hello S"+studentId);


        SharedPreferences.Editor editor = 	getSharedPreferences("studentID", MODE_PRIVATE).edit();
        editor.putString("StudentID", studentId);
        editor.apply();

        SharedPreferences prefs = 	getSharedPreferences("studentID", MODE_PRIVATE);
        String value = prefs.getString("StudentID", "");

    }

}