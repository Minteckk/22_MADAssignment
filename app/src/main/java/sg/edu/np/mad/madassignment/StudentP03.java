package sg.edu.np.mad.madassignment;

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


public class StudentP03 extends Fragment {

    // initialize
    private static final String ARG_PARAM1 = "P02";
    private static final String ARG_PARAM2 = "P03";
    // initialize recyclerview variable
    private RecyclerView recyclerView;
    // initialize student arrayList
    public ArrayList<Student> studentList;
    viewAllStudentAdapter adapter;
    // initialize
    private String P03;
    private String P04;

    public StudentP03() {
        // Required empty public constructor
    }

    // new instance of fragment
    public static StudentP03 newInstance(String P03frag, String P04frag) {
        // initialize with new fragment.
        StudentP03 fragment = new StudentP03();
        // new bundle
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, P03frag);
        args.putString(ARG_PARAM2, P04frag);
        // set argument in fragment
        fragment.setArguments(args);
        // return the fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // if arguments is not null, get string for P03 and P04 parameters.
            P03 = getArguments().getString(ARG_PARAM1);
            P04 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_p03, container, false);
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


    public ArrayList<Student> initialiseData()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> idList = new ArrayList<String>();

        // initialize db file and get the Activity
        AccountDBHandler db = new AccountDBHandler(getActivity(),null,null,2);
        // set the studentList to get students from the db file
        ArrayList<Student> studentList = db.getStudents();

        //creating 25 items for recyclerview
        if(studentList.size()==0) {
            Student NewStudent = new Student(10222326, "Soh Yi Jie Jeff", "encrypted");
            studentList.add(NewStudent);
            Student NewStudent2 = new Student(10227861, "Chua Ming Feng", "encrypted");
            studentList.add(NewStudent2);
            Student NewStudent3 = new Student(10222373, "Thu Ya Swe", "encrypted");
            studentList.add(NewStudent3);
            Student NewStudent4 = new Student(10228098, "Simon Kwek","encrypted");
            studentList.add(NewStudent4);
            Student NewStudent5 = new Student (10203894, "Tan Wen Yu", "encrypted");
            studentList.add(NewStudent5);
            Student NewStudent6 =  new Student(10222484,"Tang Ee Ann","encrypted");
            studentList.add(NewStudent6);
            Student NewStudent7 = new Student(10219290,"Mah Chen Han","encrypted");
            studentList.add(NewStudent7);
            Student NewStudent8 = new Student(10223621,"Sim Yuan Yee","encrypted");
            studentList.add(NewStudent8);
            Student NewStudent9 = new Student(10223268, "Leon Toh", "encrypted");
            studentList.add(NewStudent9);
            Student NewStudent10 = new Student(10223410, "Ali", "encrypted");
            studentList.add(NewStudent10);
            Student NewStudent11 = new Student(10192609, "Lim Junquan Ryan", "encrypted");
            studentList.add(NewStudent11);
            Student NewStudent12 = new Student(10222211, "Zi Yi Ng","encrypted");
            studentList.add(NewStudent12);
            Student NewStudent13 = new Student(10222819,"Paul Chuan", "encrypted");
            studentList.add(NewStudent13);
            Student NewStudent14 = new Student(10219568,"Lukman", "encrypted");
            studentList.add(NewStudent14);
            Student NewStudent15 =  new Student(10228054, "Lee Zhen Quan", "encrypted");
            studentList.add(NewStudent15);
            Student NewStudent16 = new Student(10227699, "Logan", "encrypted");
            studentList.add(NewStudent16);
            Student NewStudent17 = new Student(10222145,"Chua Jie Ren","encrypted");
            studentList.add(NewStudent17);
            Student NewStudent18 = new Student(10223608, "Chua Guo Heng","encrypted");
            studentList.add(NewStudent18);
            Student NewStudent19 = new Student(10222525, "Chua Jie Yi Addison", "encrypted");
            studentList.add(NewStudent19);
            Student NewStudent20 = new Student(10222254, "Liew Zheng Zhang", "encrypted");
            studentList.add(NewStudent20);
            Student NewStudent21 = new Student(10204421, "Tan Wei Jun", "encrypted");
            studentList.add(NewStudent21);
            Student NewStudent22 = new Student(10223380,"Aloysius Chin","encrypted");
            studentList.add(NewStudent22);
            Student NewStudent23 =  new Student(10227943, "Justin Chan", "encrypted");
            studentList.add(NewStudent23);
            Student NewStudent24 = new Student(10222173, "Queenie Ng", "encrypted");
            studentList.add(NewStudent24);
            Student NewStudent25 = new Student(10203927, "Low Hong Wei", "encrypted");
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
            //s._studentId = Integer.valueOf(idList.get(randomInt(idList.size()-1)));
            //s._name = nameList.get(randomInt(nameList.size()-1));
            // add the value to studentList
            //studentList.add(s);
            //i = i + 1;
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