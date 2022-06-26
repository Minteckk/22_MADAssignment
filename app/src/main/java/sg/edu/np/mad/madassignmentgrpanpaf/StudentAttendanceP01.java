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


public class StudentAttendanceP01 extends Fragment {
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<students> studentList;

    // initialize
    private static final String ARG_PARAM1 = "P01";
    private static final String ARG_PARAM2 = "P02";

    // initialize
    private String P01;
    private String P02;

    public StudentAttendanceP01() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentAttendanceP01 newInstance(String P01frag, String P02frag) {
        // initialize with new fragment.
        StudentAttendanceP01 fragment = new StudentAttendanceP01();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, P01frag);
        args.putString(ARG_PARAM2, P02frag);
        // set argument in fragment
        fragment.setArguments(args);
        // return the fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // if arguments is not null, get string for P01 and P02 parameters.
            P01 = getArguments().getString(ARG_PARAM1);
            P02 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_class, container, false);
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

        // find the id for resetAttendance button
        Button resetAttendance = view.findViewById(R.id.resetAttendance);
        // set OnClickListener for reset Attendance button
        resetAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                // set Title as "Reset Attendance?"
                builder.setTitle("Reset Attendance?");
                // set the alert dialog cancelable to false
                builder.setCancelable(false);
                // set Message
                builder.setMessage("Reset all your students attendance?");
                // onClickListener when yes is pressed.
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // new student object
                        students s = new students();
                        // set Attendance Status to false;
                        s.setAttendanceStatus(false);
                        // toast message to display Attendance has been resetted
                        Toast.makeText(getContext(),"Attendance has been resetted",Toast.LENGTH_SHORT).show();
                    }
                });
                // OnClickListener when No button is pressed
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // cancel the alert dialog
                        dialogInterface.cancel();
                    }
                });
                // create alert dialog and show
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
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();
        ArrayList<Boolean> attendanceList = new ArrayList<Boolean>();

        // initialize db file and get the Activity
        P01Handler db = new P01Handler(getActivity());
        // set the studentList to get students from the db file
        ArrayList<students> studentList = db.getStudents();
        if(studentList.size()==0) {
            //creating 25 items for recyclerview
                // initialize random
                int num3 = randomInt(1);
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
            students NewStudent = new students("Jack Tan" , "10214678", true);
            // add the object to the list
            studentList.add(NewStudent);
            // new students object
            students NewStudent2 = new students("Peter Wong" , "10221209", true);
            // add the object to the list
            studentList.add(NewStudent2);
            // new students object
            students NewStudent3 = new students("Jason Toh" , "10223402", true);
            // add the object to the list
            studentList.add(NewStudent3);
            // new students object
            students NewStudent4 = new students("Charles" , "10201405", true);
            // add the object to the list
            studentList.add(NewStudent4);
            // new students object
            students NewStudent5 = new students("Eric", "10224560",true);
            // add the object to the list
            studentList.add(NewStudent5);
            // new students object
            students NewStudent6 = new students("Johnny Tan", "10213577", true);
            // add the object to the list
            studentList.add(NewStudent6);
            // new students object
            students NewStudent7 = new students("Lim Jia Wei" , "10223570", true);
            // add the object to the list
            studentList.add(NewStudent7);
            // new students object
            students NewStudent8 = new students("Chia Jiun Hong", "10222651", true);
            // add the object to the list
            studentList.add(NewStudent8);
            // new students object
            students NewStudent9 = new students("Bryan Chua", "10223076", true);
            // add the object to the list
            studentList.add(NewStudent9);
            // new students object
            students NewStudent10 = new students("Arrick Yee", "10203210", true);
            // add the object to the list
            studentList.add(NewStudent10);
            // new students object
            students NewStudent11 = new students("Issac Koh", "10225210", true);
            // add the object to the list
            studentList.add(NewStudent11);
            // new students object
            students NewStudent12 = new students("Jimmy Lew", "10219505", true);
            // add the object to the list
            studentList.add(NewStudent12);
            // new students object
            students NewStudent13 =  new students("Owen Wong","10226780", true);
            // add the object to the list
            studentList.add(NewStudent13);
            // new students object
            students NewStudent14 = new students("Liew Wen Jun Matthew", "10222202", true);
            // add the object to the list
            studentList.add(NewStudent14);
            // new students object
            students NewStudent15 = new students("Chong Jerome", "10223203", false);
            // add the object to the list
            studentList.add(NewStudent15);
            // new students object
            students NewStudent16 = new students("Kelsie Chye", "10227054", true);
            // add the object to the list
            studentList.add(NewStudent16);
            // new students object
            students NewStudent17 = new students("Lucas Ho","10227850", true);
            // add the object to the list
            studentList.add(NewStudent17);
            // new students object
            students NewStudent18 = new students("Jason Heo", "10222947", true);
            // add the object to the list
            studentList.add(NewStudent18);
            // new students object
            students NewStudent19 = new students("Ho Kuan Zher", "10223870", true);
            // add the object to the list
            studentList.add(NewStudent19);
            // new students object
            students NewStudent20 = new students("Li Zheyun", "10222023" ,true);
            // add the object to the list
            studentList.add(NewStudent20);
            // new students object
            students NewStudent21 = new students("Daniel Chan", "10223862", true);
            // add the object to the list
            studentList.add(NewStudent21);
            // new students object
            students NewStudent22 = new students("Gan Hao Wen", "10227840", true);
            // add the object to the list
            studentList.add(NewStudent22);
            // new students object
            students NewStudent23 = new students("Cheah Seng Jun","10227333",true);
            // add the object to the list
            studentList.add(NewStudent23);
            // new students object
            students NewStudent24 = new students("Ahmad Mikail","10227809", true);
            // add the object to the list
            studentList.add(NewStudent24);
            // new students object
            students NewStudent25 = new students("Ong Jia Yuan","10227735", true);
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
            s.AttendanceStatus = attendanceList.get(randomInt(nameList.size()-1));
            // add the value to studentList
            studentList.add(s);
            i = i + 1;
        }

        // to check if students data has initialized properly
        for ( Object student : studentList)
        {
            students s = (students) student;
            System.out.println(s.Name);
        }
        // return studentList
        return studentList;
    }
}