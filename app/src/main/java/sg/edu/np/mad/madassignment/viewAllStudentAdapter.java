package sg.edu.np.mad.madassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class viewAllStudentAdapter extends RecyclerView.Adapter<ClassViewHolder> {
    ArrayList<students> data;
    Context context;

    public viewAllStudentAdapter(ArrayList<students> input, Context context) {
        this.data = input;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0) {
           item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_class_view_holder, null, false);
        }
        return new ClassViewHolder(item) ;
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        String name = data.get(position).Name;
        holder.sName.setText(name);

        String studentID = data.get(position).StudentID;
        holder.sID.setText(studentID);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
