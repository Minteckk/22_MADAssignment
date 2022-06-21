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


public class StudentP05 extends Fragment {

    // initialize
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<Student> studentList;
    viewAllStudentAdapter adapter;
    // initialize
    private String Group5;
    private String P05;

    public StudentP05() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentP05 newInstance(String Group5frag, String P05Frag ) {
        // initialize with new fragment.
        StudentP05 fragment = new StudentP05();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, Group5frag);
        args.putString(ARG_PARAM2, P05Frag);
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
            Student NewStudent = new Student(10222479 , "Tan Kwan Wei", "encrypted");
            studentList.add(NewStudent);
            Student NewStudent2 = new Student(10227383, "Emily Lim", "encrypted");
            studentList.add(NewStudent2);
            Student NewStudent3 = new Student(10223565, "Fredor Low", "encrypted");
            studentList.add(NewStudent3);
            Student NewStudent4 = new Student(10223353, "Felicia Chua","encrypted");
            studentList.add(NewStudent4);
            Student NewStudent5 = new Student (10227731, "Fong Jia Yuan", "encrypted");
            studentList.add(NewStudent5);
            Student NewStudent6 =  new Student(10203441,"Xavier Teo","encrypted");
            studentList.add(NewStudent6);
            Student NewStudent7 = new Student(10219423,"Adam Aqif","encrypted");
            studentList.add(NewStudent7);
            Student NewStudent8 = new Student(10223292,"Ang Siong Xavier Chan","encrypted");
            studentList.add(NewStudent8);
            Student NewStudent9 = new Student(10227446, "Mok Qing Ling", "encrypted");
            studentList.add(NewStudent9);
            Student NewStudent10 = new Student(10223127, "Yu Bai Lim", "encrypted");
            studentList.add(NewStudent10);
            Student NewStudent11 = new Student(10222232, "Jing Jie Gan", "encrypted");
            studentList.add(NewStudent11);
            Student NewStudent12 = new Student(10221973, "Chong Xin Le","encrypted");
            studentList.add(NewStudent12);
            Student NewStudent13 = new Student(10223330,"Zeng Jie Jeffrey Zhong", "encrypted");
            studentList.add(NewStudent13);
            Student NewStudent14 = new Student(10222783,"Jia Xin Ally Koh", "encrypted");
            studentList.add(NewStudent14);
            Student NewStudent15 =  new Student(10227481, "Zi Yi Jayne Tan", "encrypted");
            studentList.add(NewStudent15);
            Student NewStudent16 = new Student(10227827, "Sim Xiang Ying", "encrypted");
            studentList.add(NewStudent16);
            Student NewStudent17 = new Student(10223002,"Chiam Wei","encrypted");
            studentList.add(NewStudent17);
            Student NewStudent18 = new Student(10227939, "Izz Fikri","encrypted");
            studentList.add(NewStudent18);
            Student NewStudent19 = new Student(10221765, "Yi Ting Koay", "encrypted");
            studentList.add(NewStudent19);
            Student NewStudent20 = new Student(10223054, "Yeo Yuan Ting", "encrypted");
            studentList.add(NewStudent20);
            Student NewStudent21 = new Student(10223522, "Tan Raiden", "encrypted");
            studentList.add(NewStudent21);
            Student NewStudent22 = new Student(10223513,"Nathan Quek","encrypted");
            studentList.add(NewStudent22);
            Student NewStudent23 =  new Student(10222609, "Xie Ziqi", "encrypted");
            studentList.add(NewStudent23);
            Student NewStudent24 = new Student(10205467, "Loong Chor Yi", "encrypted");
            studentList.add(NewStudent24);
            Student NewStudent25 = new Student(10227870, "Natalie Koh", "encrypted");
            studentList.add(NewStudent25);

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