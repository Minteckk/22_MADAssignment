package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FeedbackViewHolder extends RecyclerView.ViewHolder {
    TextView studentId;
    TextView feedback;
    TextView date;

    public FeedbackViewHolder(View Viewitem) {
        super(Viewitem);
        studentId = Viewitem.findViewById(R.id.feedbackID);
        feedback = Viewitem.findViewById(R.id.feedbackReceived);
        date = Viewitem.findViewById(R.id.feedbackDate);
    }

}