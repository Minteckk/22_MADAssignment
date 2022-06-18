package sg.edu.np.mad.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class StudentAttendance extends RecyclerView.ViewHolder {
    TextView studentName;
    TextView studentID;
    ImageView attendanceStatus;

    public StudentAttendance(View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.textView10);
        studentID = itemView.findViewById(R.id.textView9);
        attendanceStatus = itemView.findViewById(R.id.imageView2);
    }
}