package sg.edu.np.mad.madassignment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class viewAllStudentAdapter extends RecyclerView.Adapter<ClassViewHolder> {
    // initialize arraylist
    ArrayList<students> data;
    // get context
    Context context;

    public viewAllStudentAdapter(ArrayList<students> input, Context context) {
        this.data = input;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // set view item to null;
        View item = null;
        // inflate layout for class view holder
        if(viewType == 0) {
           item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_class_view_holder, null, false);
        }
        // return the item in ClassViewHolder
        return new ClassViewHolder(item) ;
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        // get the position of the name
        String name = data.get(position).Name;
        // set the name
        holder.sName.setText(name);
        // get the position of the studentID
        String studentID = data.get(position).StudentID;
        // set the studentID
        holder.sID.setText(studentID);
        // set OnclickListener for imageView studentProfile
        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // build the alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                // set the title for the alert dialog
                builder.setTitle("Profile");
                // set the alert dialog cancelable to false
                builder.setCancelable(false);
                // set the alert dialog message to the student name
                builder.setMessage(name);
                // set positive button
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    // onClick Listener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // create an intent to go to student profile after clicking on the individual student profile.
                        Intent profileIntent = new Intent(context, StudentProfile.class);
                        // send the intent details to other activity.
                        profileIntent.putExtra("name", name);
                        profileIntent.putExtra("studentID", studentID);
                        // start the activity
                        context.startActivity(profileIntent);
                    }
                });
                // set the negative button
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // cancel the alert dialog
                        dialogInterface.cancel();
                    }
                });
                // create the alert dialog
                AlertDialog alert = builder.create();
                // show the alert dialog
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
