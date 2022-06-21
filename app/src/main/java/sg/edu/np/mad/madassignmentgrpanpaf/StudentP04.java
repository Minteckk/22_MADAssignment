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


public class StudentP04 extends Fragment {

    // initialize
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<Student> studentList;
    viewAllStudentAdapter adapter;
    // initialize
    private String P04;
    private String P05;

    public StudentP04() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentP04 newInstance(String P04frag, String P05frag) {
        // initialize with new fragment.
        StudentP04 fragment = new StudentP04();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, P04frag);
        args.putString(ARG_PARAM2, P05frag);
        // set argument in fragment
        fragment.setArguments(args);
        // return the fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // if arguments is not null, get string for P04 and P05 parameters.
            P04 = getArguments().getString(ARG_PARAM1);
            P05 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_p04, container, false);
        // call the initialiseData method
        studentList = initialiseData();
        // find the id of the recyclerview
        recyclerView = view.findViewById(R.id.viewAllStudents);

        // initialise layout manager with context.
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        //initialise adapter
        adapter = new viewAllStudentAdapter(studentList,getContext());
        // set the layout manager for recyclerview
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // set adapter
        recyclerView.setAdapter(adapter);

        // return the view
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //Generate random int value from 0 to given number
    public int randomInt(int ceiling)
    {
        int min = 0;
        int max = ceiling;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public ArrayList<Student> initialiseData()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> idList = new ArrayList<String>();

        // initialize db file and get the Activity
        AccountDBHandler db = new AccountDBHandler(getActivity(),null,null,2);
        // set the studentList to get students from the db file
        ArrayList<Student> studentList = db.getStudents();

        //creating 26 items for recyclerview
        if(studentList.size()==0) {
            Student NewStudent = new Student(10223779, "Low Jing Xi", "encrypted");
            studentList.add(NewStudent);
            Student NewStudent2 = new Student(10222766, "Eliezer Goh", "encrypted");
            studentList.add(NewStudent2);
            Student NewStudent3 = new Student(10222955, "Rishika Bimal Attodi", "encrypted");
            studentList.add(NewStudent3);
            Student NewStudent4 = new Student(10227533, "Tay Guo Jun","encrypted");
            studentList.add(NewStudent4);
            Student NewStudent5 = new Student (10221825, "Zheng Yi Ho", "encrypted");
            studentList.add(NewStudent5);
            Student NewStudent6 =  new Student(10223008,"Lee Hwee Min","encrypted");
            studentList.add(NewStudent6);
            Student NewStudent7 = new Student(10219574,"Yong Zi Ren","encrypted");
            studentList.add(NewStudent7);
            Student NewStudent8 = new Student(10222755,"Julius Keong","encrypted");
            studentList.add(NewStudent8);
            Student NewStudent9 = new Student(10222388, "Jyoshika", "encrypted");
            studentList.add(NewStudent9);
            Student NewStudent10 = new Student(10221987, "Lim Xin En", "encrypted");
            studentList.add(NewStudent10);
            Student NewStudent11 = new Student(10208642, "Tay Xin Ying", "encrypted");
            studentList.add(NewStudent11);
            Student NewStudent12 = new Student(10204032, "Andy Sim","encrypted");
            studentList.add(NewStudent12);
            Student NewStudent13 = new Student(10223003,"Tan Jun Xian", "encrypted");
            studentList.add(NewStudent13);
            Student NewStudent14 = new Student(10222782,"Kyler Lee", "encrypted");
            studentList.add(NewStudent14);
            Student NewStudent15 =  new Student(10222428, "Ho Yee Mei", "encrypted");
            studentList.add(NewStudent15);
            Student NewStudent16 = new Student(10223298, "Lim Hong Ying", "encrypted");
            studentList.add(NewStudent16);
            Student NewStudent17 = new Student(10205253,"Cheng Zhi Hong","encrypted");
            studentList.add(NewStudent17);
            Student NewStudent18 = new Student(10205561, "Ho Qi Ren","encrypted");
            studentList.add(NewStudent18);
            Student NewStudent19 = new Student(10222938, "Willam Siah", "encrypted");
            studentList.add(NewStudent19);
            Student NewStudent20 = new Student(10204123, "Joseph Wong", "encrypted");
            studentList.add(NewStudent20);
            Student NewStudent21 = new Student(10222337, "Shantal", "encrypted");
            studentList.add(NewStudent21);
            Student NewStudent22 = new Student(10221824,"Lim Long Teck","encrypted");
            studentList.add(NewStudent22);
            Student NewStudent23 =  new Student(10222863, "Tan Kok Kai", "encrypted");
            studentList.add(NewStudent23);
            Student NewStudent24 = new Student(10221788, "Kelven Lim", "encrypted");
            studentList.add(NewStudent24);


            // update the student to database.
            for(int b = 0; b < studentList.size(); b++) {
                db.addStudent(studentList.get(b));
            }
        }


        int i = 1;
        // check nameList
        for ( String name : nameList)
        {
            // initialize student
            Student s = new Student();
            // get the nameList and idList size.
            s._studentId = Integer.valueOf(idList.get(randomInt(idList.size()-1)));
            s._name = nameList.get(randomInt(nameList.size()-1));
            // add the value to studentList
            studentList.add(s);
            i = i + 1;
        }

        //to check if students data has initialized properly
        for ( Object student : studentList)
        {
            Student s = (Student) student;
            System.out.println(s._name);
        }

        // return studentList
        return studentList;
    }
}