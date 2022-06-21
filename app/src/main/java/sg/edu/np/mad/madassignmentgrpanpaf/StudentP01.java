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
    public ArrayList<Student> studentList;

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


    public ArrayList<Student> initialiseData() {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();


        Random random = new Random();
        // initialize db file and get the Activity
        AccountDBHandler db = new AccountDBHandler(getActivity(),null,null,2);
        // set the studentList to get students from the db file
        ArrayList<Student> studentList = db.getStudents();
        if (studentList.size() == 0) {
                // new students object
                Student NewStudent = new Student(10214678 , "Jack Tan", "encrypted");
                studentList.add(NewStudent);
                Student NewStudent2 = new Student(10221209 , "Peter Wong", "encrypted");
                studentList.add(NewStudent2);
                Student NewStudent3 = new Student(10223402 , "Jason Toh", "encrypted");
                studentList.add(NewStudent3);
                Student NewStudent4 = new Student(10201405 , "Charles", "encrypted");
                studentList.add(NewStudent4);
                Student NewStudent5 = new Student(10224560, "Eric","password");
                studentList.add(NewStudent5);
                Student NewStudent6 = new Student(10213577, "Johnny Tan", "encrypted");
                studentList.add(NewStudent6);
                Student NewStudent7 = new Student(10223570 , "Lim Jia Wei", "encrypted");
                studentList.add(NewStudent7);
                Student NewStudent8 = new Student(10222651, "Chia Jiun Hong", "encrypted");
                studentList.add(NewStudent8);
                Student NewStudent9 = new Student(10223076, "Bryan Chua", "encrypted");
                studentList.add(NewStudent9);
                Student NewStudent10 = new Student(10203210, "Arrick Yee", "encrypted");
                studentList.add(NewStudent10);
                Student NewStudent11 = new Student(10225210, "Issac Koh", "encrypted");
                studentList.add(NewStudent11);
                Student NewStudent12 = new Student(10219505, "Jimmy Lew", "encrypted");
                studentList.add(NewStudent12);
                Student NewStudent13 =  new Student(10226780,"Owen Wong", "encrypted");
                studentList.add(NewStudent13);
                Student NewStudent14 = new Student(10222202, "Liew Wen Jun Matthew", "encrypted");
                studentList.add(NewStudent14);
                Student NewStudent15 = new Student(10223203, "Chong Jerome", "encrypted");
                studentList.add(NewStudent15);
                Student NewStudent16 = new Student(10227054, "Kelsie Chye", "encrypted");
                studentList.add(NewStudent16);
                Student NewStudent17 = new Student(10227850,"Lucas Ho", "encrypted");
                studentList.add(NewStudent17);
                Student NewStudent18 = new Student(10222947, "Jason Heo", "encrypted");
                studentList.add(NewStudent18);
                Student NewStudent19 = new Student(10223870, "Ho Kuan Zher", "encrypted");
                studentList.add(NewStudent19);
                Student NewStudent20 = new Student(10222023, "Li Zheyun" ,"encrypted");
                studentList.add(NewStudent20);
                Student NewStudent21 = new Student(10223862, "Daniel Chan", "encrypted");
                studentList.add(NewStudent21);
                Student NewStudent22 = new Student(10227840, "Gan Hao Wen", "encrypted");
                studentList.add(NewStudent22);
                Student NewStudent23 = new Student(10227333,"Cheah Seng Jun","encrypted");
                studentList.add(NewStudent23);
                Student NewStudent24 = new Student(10227809,"Ahmad Mikail", "encrypted");
                studentList.add(NewStudent24);
                Student NewStudent25 = new Student(10227735,"Ong Jia Yuan", "encrypted");
                studentList.add(NewStudent25);

                // add the object to the list

            //}
            // update the student to database.
            for (int b = 0; b < studentList.size(); b++) {
                db.addStudent(studentList.get(b));
                }
            }

            int i = 1;
            // check nameList
            for (String name : nameList) {
                // initialize student
                Student s = new Student();
                // get the nameList and idList size.
                s._studentId = Integer.valueOf(idList.get(randomInt(idList.size() - 1)));
                s._name = nameList.get(randomInt(nameList.size() - 1));
                // add the value to studentList
                studentList.add(s);
                i = i + 1;
            }

            // to check if students data has initialized properly
            for (Object student : studentList) {
                Student s = (Student) student;
                System.out.println(s._name);
            }
            // return studentList
            return studentList;
        }

    }

