package sg.edu.np.mad.madassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<studentViewHolder> {
    ArrayList<students> data;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public userAdapter(ArrayList<students> input) {
        data = input;
    }

    public studentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_attendance, parent, false);

        return new studentViewHolder(item, mListener);
    }

    public void onBindViewHolder(studentViewHolder holder, int position) {
        String namevar = data.get(position).Name;
        holder.studentName.setText(namevar);

        int idvar = data.get(position).StudentID;
        holder.studentID.setText(""+idvar);
    }
    public int getItemCount()
    {
        return data.size();
    }
}