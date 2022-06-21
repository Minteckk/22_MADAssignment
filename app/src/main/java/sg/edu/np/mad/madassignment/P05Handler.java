package sg.edu.np.mad.madassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class P05Handler extends SQLiteOpenHelper {
    // create a table called P05
    public static final String TABLE_P05 = "P05";
    // define a auto increment ID
    public static final String COLUMN_ID = "Id";
    // define column name
    public static final String COLUMN_NAME = "Name";
    // define column for student ID
    public static final String COLUMN_STUDENT_ID = "StudentID";
    // define column for AttendanceStatus
    public static final String COLUMN_ATTENDANCE_STATUS = "AttendanceStatus";
    public P05Handler(@Nullable Context context) {
        super(context, "P05.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql command to create the table with ID and Name and StudentID
        String CREATE = "CREATE TABLE P05 " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT," + "StudentID TEXT," + "AttendanceStatus BOOLEAN)";
        // execute the command
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_P05);
        onCreate(db);
    }

    // method to add new student to database
    public void addNewStudent(students student) {
        // calls uploadStudent method
        ContentValues values = uploadStudent(student);
        // get Writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // insert into P05 table
        db.insert(TABLE_P05, null,values);
        // close the database connection
        db.close();
    }

    @NonNull
    // method to upload student to database
    private ContentValues uploadStudent(students student)
    {
        ContentValues values = new ContentValues();
        // put student name into students table
        values.put(COLUMN_NAME, student.getName());
        // put student id into students table
        values.put(COLUMN_STUDENT_ID, student.getStudentID());
        // put student attendance status into students table
        values.put(COLUMN_ATTENDANCE_STATUS, student.getAttendanceStatus());
        // return the value
        return values;
    }

    // method to retrieve students from database
    public ArrayList<students> getStudents()
    {
        // initialize the arraylist
        ArrayList<students> studentList = new ArrayList<>();
        // sql statements to select from students table
        String query = "SELECT * FROM " + TABLE_P05;
        // get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            students student = new students();
            student.AttendanceStatus = cursor.getExtras().getBoolean("3",false);
            student.StudentID = cursor.getString(2);
            student.Name = cursor.getString(1);
            studentList.add(student);
        }
        return studentList;
    }

}
