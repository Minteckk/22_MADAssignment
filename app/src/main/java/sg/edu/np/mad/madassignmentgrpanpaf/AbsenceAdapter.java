package sg.edu.np.mad.madassignmentgrpanpaf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AbsenceAdapter extends RecyclerView.Adapter<AbsenceViewHolder> {
    // arrayList for absent object
    ArrayList<absent> data;

    public AbsenceAdapter(ArrayList<absent> input) {
        data = input;
    }

    @NonNull
    @Override
    public AbsenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        // inflate layout for absence view holder
        if(viewType == 0) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_absence_view_holder, parent, false);
        }
        // return the item in ClassViewHolder
        return new AbsenceViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenceViewHolder holder, int position) {
        // get positions for the studentID, startDate, endDate, DateOfIssue, ClinicNo,
        // ClinicNumber, AbsenceReason,AbsenceFrom
        String studentId = data.get(position).StudentID;
        holder.StudentID.setText(studentId);
        String startDate = data.get(position).startDate;
        holder.startDate.setText(startDate);
        String endDate = data.get(position).endDate;
        holder.endDate.setText(endDate);
        String DateOfIssue = data.get(position).DateOfIssue;
        holder.DateOfIssue.setText(DateOfIssue);
        String ClinicName = data.get(position).ClinicNo;
        holder.ClinicNo.setText(ClinicName);
        String ClinicNumber = data.get(position).ClinicNumber;
        holder.ClinicNumber.setText(ClinicNumber);
        String AbsenceReason = data.get(position).AbsenceReason;
        holder.AbsenceReason.setText(AbsenceReason);
        String AbsenceFrom = data.get(position).AbsenceFrom;
        holder.AbsenceFrom.setText(AbsenceFrom);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
