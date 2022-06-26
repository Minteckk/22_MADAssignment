package sg.edu.np.mad.madassignmentgrpanpaf;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class studentAttendanceViewHolder extends RecyclerView.ViewHolder{
    // variables
    TextView studentName;
    TextView studentID;
    ImageView attendanceCheck;

    public studentAttendanceViewHolder(View itemView, studentAttendanceAdapter.OnItemClickListener listener) {
        super(itemView);
        // find the id for studentName and ID
        studentName = itemView.findViewById(R.id.textView10);
        studentID = itemView.findViewById(R.id.textView9);
        // find the id for the attendanceCheck checkbox
        attendanceCheck = itemView.findViewById(R.id.imageView2);

        // OnClickListener for attendance checkbox
        attendanceCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if listener is not null, get BindingAdapter position
                if (listener != null)
                {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                    {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
