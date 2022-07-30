package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import sg.edu.np.mad.madassignmentgrpanpaf.databinding.ActivityMainLecturerBinding;

public class MainLecturer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainLecturerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainLecturerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainStudent.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.viewAllStudentAttendance2, R.id.viewAllStudents2)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_student);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        ImageView studentView = findViewById(R.id.studentView);
        studentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoViewAttendance = new Intent(MainLecturer.this,ViewAllStudentAttendance.class);
                startActivity(gotoViewAttendance);
            }
        });

        ImageView studentFeedback = findViewById(R.id.viewStudent);
        studentFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoFeedback = new Intent(MainLecturer.this,ViewAllStudents.class);
                startActivity(gotoFeedback);
            }
        });

        ImageView studentAbsent = findViewById(R.id.absentimg);
        studentAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoAbsent = new Intent(MainLecturer.this, StudentAbsenceRecord.class);
                startActivity(gotoAbsent);
            }
        });

        TextView username = findViewById(R.id.text_home);
        Intent i = getIntent();
        // get Lecturer Name from Lecturer Login
        String lecUsername = i.getStringExtra("Username");
        // set the textView to lecturer user name
        // Shared Preferences
        SharedPreferences prefs = 	getSharedPreferences("UsernameSP", MODE_PRIVATE);
        String value = prefs.getString("Username","");
        username.setText("Welcome " + value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_lecturer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_student);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}