package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.ArrayList;

public class ViewAllStudents extends AppCompatActivity {
    public ArrayList<students> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        ImageView iv = findViewById(R.id.view_all_students_back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewAllStudents.this, LecturerMain.class);
                startActivity(i);
            }
        });

       Button P01Class = findViewById(R.id.P01);
       P01Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentClass fragment1 = StudentClass.newInstance("P01","P02");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });
       Button P02Class = findViewById(R.id.P02);
       P02Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentP02 fragment1 = StudentP02.newInstance("P02","P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });
       Button P03Class = findViewById(R.id.P03);
       P03Class.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               StudentP03 fragment1 = StudentP03.newInstance("P03", "P03");
               ft.replace(R.id.Frame, fragment1);
               ft.commit();
           }
       });
        Button P04Class = findViewById(R.id.P04);
        P04Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentP04 fragment1 = StudentP04.newInstance("P04", "P05");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });
        Button P05Class = findViewById(R.id.P05);
        P05Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                StudentP05 fragment1 = StudentP05.newInstance("P05", "P06");
                ft.replace(R.id.Frame, fragment1);
                ft.commit();
            }
        });
    }


}

