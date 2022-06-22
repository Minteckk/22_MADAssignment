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
    public ArrayList<students> studentList;
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

    public ArrayList<students> initialiseData()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> idList = new ArrayList<String>();

        // initialize db file and get the Activity
        P02Handler db = new P02Handler(getActivity());
        // set the studentList to get students from the db file
        ArrayList<students> studentList = db.getStudents();

        //creating 26 items for recyclerview
        if(studentList.size()==0) {
            students NewStudent = new students("Lu Junxi" , "10219098", true);
            studentList.add(NewStudent);
            students NewStudent2 = new students("Lee Wei Jun Nicholas", "10222425", true);
            studentList.add(NewStudent2);
            students NewStudent3 = new students("Ho Min Teck", "10228079", true);
            studentList.add(NewStudent3);
            students NewStudent4 = new students("Hanisah Binte Musrin", "10226112",true);
            studentList.add(NewStudent4);
            students NewStudent5 = new students ("Koh En Yang", "10222282", true);
            studentList.add(NewStudent5);
            students NewStudent6 =  new students("Tan Jun Wei Gareth","10223079",true);
            studentList.add(NewStudent6);
            students NewStudent7 = new students("Nuralfian","10228111",true);
            studentList.add(NewStudent7);
            students NewStudent8 = new students("Isabelle Pak Yi Shan","10222456",true);
            studentList.add(NewStudent8);
            students NewStudent9 = new students("Tan Hui Xin", "10223047", true);
            studentList.add(NewStudent9);
            students NewStudent10 = new students("Elliot Ng", "10222410", true);
            studentList.add(NewStudent10);
            students NewStudent11 = new students("Ming Ze Ang", "10203953", true);
            studentList.add(NewStudent11);
            students NewStudent12 = new students("Yong Zong Han Ryan", "10219317",true);
            studentList.add(NewStudent12);
            students NewStudent13 = new students("Ong Yu Chen","10223650", true);
            studentList.add(NewStudent13);
            students NewStudent14 = new students("Kuan Yan Yong","10222954", true);
            studentList.add(NewStudent14);
            students NewStudent15 =  new students("Goh Shan Lun", "10222855", true);
            studentList.add(NewStudent15);
            students NewStudent16 = new students("Ng Ray Zin", "10222457", true);
            studentList.add(NewStudent16);
            students NewStudent17 = new students("Lye Wei Kang","10221838",true);
            studentList.add(NewStudent17);
            students NewStudent18 = new students("Leo Yun Tao","10219150" ,true);
            studentList.add(NewStudent18);
            students NewStudent19 = new students("Tan Zhi Yuan", "10222641", true);
            studentList.add(NewStudent19);
            students NewStudent20 = new students("Shuqri Bin Shaifuddin", "10227932", true);
            studentList.add(NewStudent20);
            students NewStudent21 = new students("Yee Jia Chen", "10219344", true);
            studentList.add(NewStudent21);
            students NewStudent22 = new students("Tan Jin Daat","10222867",true);
            studentList.add(NewStudent22);
            students NewStudent23 =  new students("Wan Rong Joshua Wong", "10222829", true);
            studentList.add(NewStudent23);
            students NewStudent24 = new students("Wei Lun Ong", "10222794", true);
            studentList.add(NewStudent24);
            students NewStudent25 = new students("Lai Wai Hang", "10219615", true);
            studentList.add(NewStudent25);
            students NewStudent26 = new students("Koh Jun Hao Griffin", "10223376", true);
            studentList.add(NewStudent26);

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
            s.Name = String.valueOf(idList.get(randomInt(idList.size()-1)));
            s.StudentID = nameList.get(randomInt(nameList.size()-1));
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