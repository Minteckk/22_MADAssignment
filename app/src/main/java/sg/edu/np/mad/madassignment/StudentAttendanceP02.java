package sg.edu.np.mad.madassignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;


public class StudentAttendanceP02 extends Fragment {

    // initialize
    private static final String ARG_PARAM1 = "P02";
    private static final String ARG_PARAM2 = "P03";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<students> studentList;
    // initialize
    private String P02;
    private String P03;

    public StudentAttendanceP02() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentAttendanceP02 newInstance(String P02frag, String P03frag) {
        // initialize with new fragment.
        StudentAttendanceP02 fragment = new StudentAttendanceP02();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, P02frag);
        args.putString(ARG_PARAM2, P03frag);
        // set argument in fragment
        fragment.setArguments(args);
        // return the fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // if arguments is not null, get string for P02 and P03 parameters.
            P02 = getArguments().getString(ARG_PARAM1);
            P03 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_p02, container, false);
        // call the initialiseData method
        studentList = initialiseData();
        // find the id of the recyclerview
        recyclerView = view.findViewById(R.id.viewAllStudents);
        //initialise adapter
        studentAttendanceAdapter aAdapter = new studentAttendanceAdapter(studentList,getContext());
        // initialise layout manager with context.
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        // set the layout manager for recyclerview
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // set adapter
        recyclerView.setAdapter(aAdapter);

        //making the checkbox interactable
        aAdapter.setOnItemClickListener(new studentAttendanceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                students s = studentList.get(position);
                //creatingAlert(s);
            }
        });
        // return the view
        return view;
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
        ArrayList<String> idList = new ArrayList<String>();

        // initialize db file and get the Activity
        P02Handler db = new P02Handler(getActivity());
        // set the studentList to get students from the db file
        ArrayList<students> studentList = db.getStudents();

        //creating 25 items for recyclerview
        if(studentList.size()==0) {
            for (int i = 0; i < 25; i++)
            {
                // initialize random
                Random random = new Random();
                int num1 = randomInt(10000);
                int num2 = random.nextInt(10229999);
                int num3 = random.nextInt(1);
                Boolean check;
                if (num3 ==1)
                {
                    check = true;
                }
                else
                {
                    check = false;
                }
                // new students object
                students NewStudent = new students("Name: "+num1,"StudentID: "+num2,check);
                // add the object to the list
                studentList.add(NewStudent);
            }
            // update the student to database.
            for(int b = 0; b < studentList.size(); b++) {
                db.addNewStudent(studentList.get(b));
            }
        }


        int i = 1;
        // check nameList
        for ( String name : nameList)
        {
            // initialize student
            students s = new students();
            // get the nameList and idList size.
            s.StudentID = String.valueOf(idList.get(randomInt(idList.size()-1)));
            s.Name = nameList.get(randomInt(nameList.size()-1));
            // add the value to studentList
            studentList.add(s);
            i = i + 1;
        }

        //to check if students data has initialized properly
        for ( Object student : studentList)
        {
            students s = (students) student;
            System.out.println(s.Name);
        }

        // return studentList
        return studentList;
    }
}