package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class feedbackAdapter extends RecyclerView.Adapter<FeedbackViewHolder> {
    ArrayList<attendance> data;
    Context context;

    public feedbackAdapter(ArrayList<attendance> input, Context context) {
        this.data = input;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        // inflate layout for class view holder
        if(viewType == 0) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_feedback_view_holder, parent, false);
        }
        // return the item in ClassViewHolder
        return new FeedbackViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        String studentId = data.get(position).studentId;
        holder.studentId.setText(studentId);
        String feedback = data.get(position).feedback;
        holder.feedback.setText(feedback);
        String dateofFeedback = data.get(position).date;
        holder.date.setText(dateofFeedback);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
