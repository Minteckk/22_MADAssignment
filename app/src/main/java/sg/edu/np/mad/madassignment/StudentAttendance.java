package sg.edu.np.mad.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class StudentAttendance extends RecyclerView.ViewHolder {
    TextView studentName;
    TextView studentID;
    ImageView attendanceCheck;

    public StudentAttendance(View itemView, userAdapter.OnItemClickListener mListener) {
        super(itemView);
        studentName = itemView.findViewById(R.id.textView10);
        studentID = itemView.findViewById(R.id.textView9);
        attendanceCheck = itemView.findViewById(R.id.imageView2);
    }
}