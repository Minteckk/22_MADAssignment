package sg.edu.np.mad.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClassViewHolder extends RecyclerView.ViewHolder {
    TextView sName;
    TextView sID;

    public ClassViewHolder( View ViewItem) {
        super(ViewItem);
        sName = ViewItem.findViewById(R.id.sName);
        sID = ViewItem.findViewById(R.id.sID);
    }


}