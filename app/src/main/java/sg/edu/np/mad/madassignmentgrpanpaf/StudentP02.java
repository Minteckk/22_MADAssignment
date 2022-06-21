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


public class StudentP02 extends Fragment {

    // initialize
    private static final String ARG_PARAM1 = "P02";
    private static final String ARG_PARAM2 = "P03";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<Student> studentList;
    viewAllStudentAdapter adapter;
    // initialize
    private String P02;
    private String P03;

    public StudentP02() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentP02 newInstance(String P02frag, String P03frag) {
        // initialize with new fragment.
        StudentP02 fragment = new StudentP02();
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
            Student NewStudent = new Student(10219098 , "Lu Junxi", "encrypted");
            studentList.add(NewStudent);
            Student NewStudent2 = new Student(10222425, "Lee Wei Jun Nicholas", "encrypted");
            studentList.add(NewStudent2);
            Student NewStudent3 = new Student(10228079, "Ho Min Teck", "encrypted");
            studentList.add(NewStudent3);
            Student NewStudent4 = new Student(10226112, "Hanisah Binte Musrin","encrypted");
            studentList.add(NewStudent4);
            Student NewStudent5 = new Student (10222282, "Koh En Yang", "encrypted");
            studentList.add(NewStudent5);
            Student NewStudent6 =  new Student(10223079,"Tan Jun Wei Gareth","encrypted");
            studentList.add(NewStudent6);
            Student NewStudent7 = new Student(10228111,"Nuralfian","encrypted");
            studentList.add(NewStudent7);
            Student NewStudent8 = new Student(10222456,"Isabelle Pak Yi Shan","encrypted");
            studentList.add(NewStudent8);
            Student NewStudent9 = new Student(10223047, "Tan Hui Xin", "encrypted");
            studentList.add(NewStudent9);
            Student NewStudent10 = new Student(10222410, "Elliot Ng", "encrypted");
            studentList.add(NewStudent10);
            Student NewStudent11 = new Student(10203953, "Ming Ze Ang", "encrypted");
            studentList.add(NewStudent11);
            Student NewStudent12 = new Student(10219317, "Yong Zong Han Ryan","encrypted");
            studentList.add(NewStudent12);
            Student NewStudent13 = new Student(10223650,"Ong Yu Chen", "encrypted");
            studentList.add(NewStudent13);
            Student NewStudent14 = new Student(10222954,"Kuan Yan Yong", "encrypted");
            studentList.add(NewStudent14);
            Student NewStudent15 =  new Student(10222855, "Goh Shan Lun", "encrypted");
            studentList.add(NewStudent15);
            Student NewStudent16 = new Student(10222457, "Ng Ray Zin", "encrypted");
            studentList.add(NewStudent16);
            Student NewStudent17 = new Student(10221838,"Lye Wei Kang","encrypted");
            studentList.add(NewStudent17);
            Student NewStudent18 = new Student(10219150, "Leo Yun Tao","encrypted");
            studentList.add(NewStudent18);
            Student NewStudent19 = new Student(10222641, "Tan Zhi Yuan", "encrypted");
            studentList.add(NewStudent19);
            Student NewStudent20 = new Student(10227932, "Shuqri Bin Shaifuddin", "encrypted");
            studentList.add(NewStudent20);
            Student NewStudent21 = new Student(10219344, "Yee Jia Chen", "encrypted");
            studentList.add(NewStudent21);
            Student NewStudent22 = new Student(10222867,"Tan Jin Daat","encrypted");
            studentList.add(NewStudent22);
            Student NewStudent23 =  new Student(10222829, "Wan Rong Joshua Wong", "encrypted");
            studentList.add(NewStudent23);
            Student NewStudent24 = new Student(10222794, "Wei Lun Ong", "encrypted");
            studentList.add(NewStudent24);
            Student NewStudent25 = new Student(10219615, "Lai Wai Hang", "encrypted");
            studentList.add(NewStudent25);
            Student NewStudent26 = new Student(10223376, "Koh Jun Hao Griffin", "encrypted");
            studentList.add(NewStudent26);

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