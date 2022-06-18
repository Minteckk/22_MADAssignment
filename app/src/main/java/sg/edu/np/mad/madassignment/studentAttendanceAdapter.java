package sg.edu.np.mad.madassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class studentAttendanceAdapter extends RecyclerView.Adapter<studentAttendanceViewHolder> {
    ArrayList<students> data;
    Context context;
    private OnItemClickListener mListener;

    public studentAttendanceAdapter(ArrayList<students> input, Context context) {
        this.data = input;
        this.context = context;
    }

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public studentAttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_attendance, parent, false);

        return new studentAttendanceViewHolder(item, mListener);
    }

    //to set each student in the recyclerview
    public void onBindViewHolder(studentAttendanceViewHolder holder, int position) {
        String namevar = data.get(position).Name;
        holder.studentName.setText(namevar);

        String idvar = data.get(position).StudentID;
        holder.studentID.setText(idvar);

        Boolean attendancevar = data.get(position).AttendanceStatus;
        if (attendancevar == false)
        {
            holder.attendanceCheck.setImageResource(android.R.drawable.checkbox_off_background);
        }
        else
        {
            holder.attendanceCheck.setImageResource(android.R.drawable.checkbox_on_background);
        }
    }
    public int getItemCount()
    {
        return data.size();
    }
}