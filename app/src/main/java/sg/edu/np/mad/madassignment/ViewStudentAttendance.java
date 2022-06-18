package sg.edu.np.mad.madassignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewStudentAttendance extends AppCompatActivity{
    public ArrayList<students> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_attendance);

        studentList = initialiseData();

        RecyclerView recyclerView = findViewById(R.id.viewStudentAttendance);

        //set adapter
        userAdapter mAdapter = new userAdapter(studentList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //making the checkbox interactable
        mAdapter.setOnItemClickListener(new userAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                students s = studentList.get(position);
                //creatingAlert(s);
            }
        });
    }

    //Generate random int value from 0 to given number
    public int randomInt(int ceiling)
    {
        int min = 0;
        int max = ceiling;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public ArrayList<students> initialiseData()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();

        //creating 20 items for recyclerview
        for (int i = 0; i < 20; i++)
        {
            nameList.add("Name"+randomInt(10000));
            idList.add(randomInt(100));
        }

        int i = 1;

        ArrayList<students> studentList = new ArrayList<students>();
        for ( String name : nameList)
        {
            students s = new students();

            s.StudentID = String.valueOf(idList.get(randomInt(idList.size()-1)));
            s.Name = nameList.get(randomInt(nameList.size()-1));

            studentList.add(s);
            i = i + 1;
        }

        //to check if students data has intialized properly
        for ( Object student : studentList)
        {
            students s = (students) student;
            System.out.println(s.Name);
        }

        return studentList;
    }

    /*
    public void creatingAlert(students s)
    {
        //Creating the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirmation");

        if (s.AttendanceStatus == false)
        {
            builder.setMessage("Mark " + s.Name + "as Present?");
        }
        else
        {
            builder.setMessage("Mark " + s.Name + "as Absent?");
        }

        builder.setCancelable(true);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                ImageView img = (ImageView)findViewById(R.id.imageView2);

                if (s.AttendanceStatus == false)
                {
                    img.setImageResource(android.R.drawable.checkbox_on_background);
                    Toast.makeText(getApplicationContext(),"Student Present", Toast.LENGTH_SHORT).show();
                    s.AttendanceStatus = true;

                }
                else
                {
                    img.setImageResource(android.R.drawable.checkbox_off_background);
                    Toast.makeText(getApplicationContext(),"Student Absent", Toast.LENGTH_SHORT).show();
                    s.AttendanceStatus = false;
                }
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
     */

}
