package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class P01Handler extends SQLiteOpenHelper {
    // create a table called Students
    public static final String TABLE_STUDENTS = "Students";

    // define a auto increment ID
    public static final String COLUMN_ID = "Id";

    // define column name
    public static final String COLUMN_NAME = "Name";

    // define column for student ID
    public static final String COLUMN_STUDENT_ID = "StudentID";

    // define column for AttendanceStatus
    public static final String COLUMN_ATTENDANCE_STATUS = "AttendanceStatus";



    public P01Handler(Context context) { super(context, "students.db", null, 11);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql command to create the table with ID and Name and StudentID
        String CREATE = "CREATE TABLE Students " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT," + "StudentID TEXT,"  + "AttendanceStatus BOOLEAN)";
        // execute the command
        db.execSQL(CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }
    // method to add new student to database
    public void addNewStudent(students student) {
        // calls uploadStudent method
        ContentValues values = uploadStudent(student);
        // get Writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // insert into Students table
        db.insert(TABLE_STUDENTS, null,values);
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
        ArrayList<students> studentaList = new ArrayList<>();
        // sql statements to select from students table
        String query = "SELECT * FROM " + TABLE_STUDENTS;
        // get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            students student = new students();
            student.AttendanceStatus = cursor.getExtras().getBoolean("3",false);
            student.StudentID = cursor.getString(2);
            student.Name = cursor.getString(1);
            studentaList.add(student);
        }
        return studentaList;
    }

}
