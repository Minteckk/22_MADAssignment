package sg.edu.np.mad.madassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;


public class StudentClass extends Fragment {
    private RecyclerView recyclerView;
    public ArrayList<students> studentList;

    private static final String ARG_PARAM1 = "P01";
    private static final String ARG_PARAM2 = "P02";

    private String P01;
    private String P02;

    public StudentClass() {
    }

    public static StudentClass newInstance(String P01frag, String P02frag) {
        StudentClass fragment = new StudentClass();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, P01frag);
        args.putString(ARG_PARAM2, P02frag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            P01 = getArguments().getString(ARG_PARAM1);
            P02 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_class, container, false);
        studentList = initialiseData();
        recyclerView = view.findViewById(R.id.viewAllStudents);
        //set adapter
        viewAllStudentAdapter aAdapter = new viewAllStudentAdapter(studentList,getContext());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);

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
        //ArrayList<students> studentList = new ArrayList<students>();
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Integer> idList = new ArrayList<Integer>();

        //creating 25 items for recyclerview
        SQLAdapter db = new SQLAdapter(getActivity());

        ArrayList<students> studentList = db.getStudents();
        if(studentList.size()==0) {
            for (int a = 0; a < 25; a++) {
                Random random = new Random();
                int num1 = randomInt(10000);
                int num2 = random.nextInt(10229999);

                idList.add(randomInt(100));
                students NewStudent = new students("Name: "+num1,"StudentID: "+num2);
                studentList.add(NewStudent);
            }
            for(int b = 0; b < studentList.size(); b++) {
                db.addNewStudent(studentList.get(b));
            }
        }

        int i = 1;

        for ( String name : nameList)
        {
            students s = new students();

            s.StudentID = String.valueOf(idList.get(randomInt(idList.size()-1)));
            s.Name = nameList.get(randomInt(nameList.size()-1));

            studentList.add(s);
            i = i + 1;
        }

        //to check if students data has intialized properly
        for ( Object student : studentList)
        {
            students s = (students) student;
            System.out.println(s.Name);
        }

        return studentList;
    }

}
