package sg.edu.np.mad.madassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class viewAllStudentAdapter extends RecyclerView.Adapter<ClassViewHolder> {
    ArrayList<students> data;

    public viewAllStudentAdapter(ArrayList<students> input) {
        data = input;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_class_view_holder, null, false);
        return new ClassViewHolder(item) ;
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        String namevar = data.get(position).Name;
        holder.sName.setText(namevar);

        String idvar = data.get(position).StudentID;
        holder.sID.setText(""+idvar);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
