package sg.edu.np.mad.madassignmentgrpanpaf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAttendanceP05 extends Fragment {

     // initialize
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<students> studentList;

    // initialize
    private String Group5;
    private String P05;

    // constructor
    public StudentAttendanceP05() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentAttendanceP05 newInstance(String Group5Frag, String P05Frag) {
        // initialize with new fragment.
        StudentAttendanceP05 fragment = new StudentAttendanceP05();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, Group5Frag);
        args.putString(ARG_PARAM2, P05Frag);
        // set argument in fragment
        fragment.setArguments(args);
        // return the fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // if arguments is not null, get string for group5 frag and P05 parameters.
        if (getArguments() != null) {
            Group5 = getArguments().getString(ARG_PARAM1);
            P05 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_p05, container, false);
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

        // find the id of the reset attendance button and set OnClickListener for it
        Button resetAttendance = view.findViewById(R.id.resetAttendance5);
        resetAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                // set Title
                builder.setTitle("Reset Attendance?");
                // set Cancelable to false
                builder.setCancelable(false);
                // set Message
                builder.setMessage("Reset all your students attendance?");
                // OnClick Listener when yes button is pressed.
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // set Attendance status to false when the button is pressed.
                        students s = new students();
                        s.setAttendanceStatus(false);
                        // Toast Message to display the attendance has been resetted
                        Toast.makeText(getContext(),"Attendance has been resetted",Toast.LENGTH_SHORT).show();
                    }
                });
                // OnClick Listener when No button is pressed.
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // cancel the alert dialog
                        dialogInterface.cancel();
                    }
                });
                // create the alert dialog and show it
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //making the checkbox interactable
        aAdapter.setOnItemClickListener(new studentAttendanceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                students s = studentList.get(position);

                //Creating the alert
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Confirmation");

                if (s.AttendanceStatus == false)
                {
                    builder.setMessage("Mark " + s.Name + " as Present?");
                }
                else
                {
                    builder.setMessage("Mark " + s.Name + " as Absent?");
                }

                builder.setCancelable(true);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        if (s.AttendanceStatus == false)
                        {
                            Toast.makeText(getContext(),"Student Present", Toast.LENGTH_SHORT).show();
                            s.setAttendanceStatus(true);
                            aAdapter.notifyItemChanged(position);
                        }
                        else
                        {
                            Toast.makeText(getContext(),"Student Absent", Toast.LENGTH_SHORT).show();
                            s.setAttendanceStatus(false);
                            aAdapter.notifyItemChanged(position);
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
        });
        // return the view
        return view;
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
        // initialize nameList and idList
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> idList = new ArrayList<String>();

        // initialize db file and get the Activity
        P05Handler db = new P05Handler(getActivity());
        // set the studentList to get students from the db file
        ArrayList<students> studentList = db.getStudents();


        //creating 25 items for recyclerview
        if(studentList.size()==0)
        {
            // create new students object
            students NewStudent = new students("Tan Kwan Wei" , "10222479", true);
            // add the object to the list
            studentList.add(NewStudent);
            // create new students object
            students NewStudent2 = new students("Emily Lim", "10227383", true);
            // add the object to the list
            studentList.add(NewStudent2);
            // create new students object
            students NewStudent3 = new students("Fredor Low", "10223565", true);
            // add the object to the list
            studentList.add(NewStudent3);
            // create new students object
            students NewStudent4 = new students("Felicia Chua", "10223353",true);
            // add the object to the list
            studentList.add(NewStudent4);
            // create new students object
            students NewStudent5 = new students ("Fong Jia Yuan", "10227731", true);
            // add the object to the list
            studentList.add(NewStudent5);
            // create new students object
            students NewStudent6 =  new students("Xavier Teo","10203441",true);
            // add the object to the list
            studentList.add(NewStudent6);
            // create new students object
            students NewStudent7 = new students("Adam Aqif","10219423",true);
            // add the object to the list
            studentList.add(NewStudent7);
            // create new students object
            students NewStudent8 = new students("Ang Siong Xavier Chan","10223292",true);
            // add the object to the list
            studentList.add(NewStudent8);
            // create new students object
            students NewStudent9 = new students("Mok Qing Ling", "10227446", true);
            // add the object to the list
            studentList.add(NewStudent9);
            // create new students object
            students NewStudent10 = new students("Yu Bai Lim", "10223127", true);
            // add the object to the list
            studentList.add(NewStudent10);
            // create new students object
            students NewStudent11 = new students("Jing Jie Gan", "10222232", true);
            // add the object to the list
            studentList.add(NewStudent11);
            // create new students object
            students NewStudent12 = new students("Chong Xin Le", "10221973",true);
            // add the object to the list
            studentList.add(NewStudent12);
            // create new students object
            students NewStudent13 = new students("Zeng Jie Jeffrey Zhong","10223330", true);
            // add the object to the list
            studentList.add(NewStudent13);
            // create new students object
            students NewStudent14 = new students("Jia Xin Ally Koh","10222783", true);
            // add the object to the list
            studentList.add(NewStudent14);
            // create new students object
            students NewStudent15 =  new students("Zi Yi Jayne Tan", "10227481", true);
            // add the object to the list
            studentList.add(NewStudent15);
            // create new students object
            students NewStudent16 = new students("Sim Xiang Ying", "10227827", true);
            // add the object to the list
            studentList.add(NewStudent16);
            // create new students object
            students NewStudent17 = new students("Chiam Wei","10223002",true);
            // add the object to the list
            studentList.add(NewStudent17);
            // create new students object
            students NewStudent18 = new students("Izz Fikri", "10227939",true);
            // add the object to the list
            studentList.add(NewStudent18);
            // create new students object
            students NewStudent19 = new students("Yi Ting Koay", "10221765", true);
            // add the object to the list
            studentList.add(NewStudent19);
            // create new students object
            students NewStudent20 = new students("Yeo Yuan Ting", "10223054", true);
            // add the object to the list
            studentList.add(NewStudent20);
            // create new students object
            students NewStudent21 = new students("Tan Raiden", "10223522", true);
            // add the object to the list
            studentList.add(NewStudent21);
            // create new students object
            students NewStudent22 = new students("Nathan Quek","10223513",true);
            // add the object to the list
            studentList.add(NewStudent22);
            // create new students object
            students NewStudent23 =  new students("Xie Ziqi", "10222609", true);
            // add the object to the list
            studentList.add(NewStudent23);
            // create new students object
            students NewStudent24 = new students("Loong Chor Yi", "10205467", true);
            // add the object to the list
            studentList.add(NewStudent24);
            // create new students object
            students NewStudent25 = new students("Natalie Koh", "10227870", true);
            // add the object to the list
            studentList.add(NewStudent25);

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