package sg.edu.np.mad.madassignmentgrpanpaf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AbsenceViewHolder extends RecyclerView.ViewHolder {
    // Text variables
    TextView startDate;
    TextView endDate;
    TextView DateOfIssue;
    TextView ClinicNo;
    TextView ClinicNumber;
    TextView StudentID;
    TextView AbsenceReason;
    TextView AbsenceFrom;

    public AbsenceViewHolder(@NonNull View itemView) {
        super(itemView);
        // find the id of the input fields.
        startDate = itemView.findViewById(R.id.abs_start);
        endDate = itemView.findViewById(R.id.abs_end);
        DateOfIssue = itemView.findViewById(R.id.abs_doi);
        ClinicNo = itemView.findViewById(R.id.abs_cName);
        ClinicNumber = itemView.findViewById(R.id.abs_cNumber);
        StudentID = itemView.findViewById(R.id.abs_SID);
        AbsenceReason = itemView.findViewById(R.id.absfr);
        AbsenceFrom = itemView.findViewById(R.id.abs_rs);
    }

}