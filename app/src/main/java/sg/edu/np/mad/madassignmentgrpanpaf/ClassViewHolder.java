package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassViewHolder extends RecyclerView.ViewHolder {
    // variable for studentName textview
    TextView sName;
    // variable for studentID textview
    TextView sID;
    // variable for profile textview
    ImageView profile;

    public ClassViewHolder( View ViewItem) {
        super(ViewItem);
        // find the id for studentName
        sName = ViewItem.findViewById(R.id.sName);
        // find the id for studentId
        sID = ViewItem.findViewById(R.id.sID);
        // find the id for studentProfile
        profile = ViewItem.findViewById(R.id.profile);
    }
}