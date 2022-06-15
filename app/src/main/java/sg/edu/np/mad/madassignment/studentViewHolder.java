package sg.edu.np.mad.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class studentViewHolder extends RecyclerView.ViewHolder{
    TextView studentName;
    TextView studentID;
    ImageView attendanceCheck;

    public studentViewHolder(View itemView, userAdapter.OnItemClickListener listener) {
        super(itemView);
        studentName = itemView.findViewById(R.id.textView10);
        studentID = itemView.findViewById(R.id.textView9);
        attendanceCheck = itemView.findViewById(R.id.imageView2);

        attendanceCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                    {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
