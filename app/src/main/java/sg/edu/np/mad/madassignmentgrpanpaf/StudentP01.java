package sg.edu.np.mad.madassignmentgrpanpaf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.Random;


public class StudentP01 extends Fragment {
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

    public StudentP01() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentP01 newInstance(String P01frag, String P02frag) {
        // initialize with new fragment.
        StudentP01 fragment = new StudentP01();
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
        viewAllStudentAdapter aAdapter = new viewAllStudentAdapter(studentList, getContext());
        // initialise layout manager with context.
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        // set the layout manager for recyclerview
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // set adapter
        recyclerView.setAdapter(aAdapter);
        // return the view
        return view;
    }

    //Generate random int value from 0 to given number
    public int randomInt(int ceiling) {
        int min = 0;
        int max = ceiling;

        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }


    public ArrayList<students> initialiseData() {
        // initialize list
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();

        Random random = new Random();
        // initialize db file and get the Activity
        P01Handler db = new P01Handler(getActivity());
        // set the studentList to get students from the db file
        ArrayList<students> studentList = db.getStudents();
        if (studentList.size() == 0) {
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
                students NewStudent15 = new students("Chong Jerome", "10223203", true);
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
            for (int b = 0; b < studentList.size(); b++) {
                db.addNewStudent(studentList.get(b));
                }
            }

            int i = 1;
            // check nameList
            for (String name : nameList) {
                // initialize student
                students s = new students();
                // get the nameList and idList size.
                s.StudentID = String.valueOf(idList.get(randomInt(idList.size() - 1)));
                s.Name = nameList.get(randomInt(nameList.size() - 1));
                // add the value to studentList
                studentList.add(s);
                i = i + 1;
            }

            // to check if students data has initialized properly
            for (Object student : studentList) {
                students s = (students) student;
                System.out.println(s.Name);
            }
            // return studentList
            return studentList;
        }

    }

