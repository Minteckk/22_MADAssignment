package sg.edu.np.mad.madassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SQLAdapter extends SQLiteOpenHelper {

    public static final String TABLE_STUDENTS = "Students";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_STUDENT_ID = "Student ID";


    public SQLAdapter(Context context) { super(context, "students.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE Students " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT," + "StudentID TEXT)";

        db.execSQL(CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public void addNewStudent(students student) {
        ContentValues values = uploadStudent(student);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_STUDENTS, null,values);
        db.close();

    }

    @NonNull
    private ContentValues uploadStudent(students student)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_STUDENT_ID, student.getStudentID());
        return values;
    }

    public ArrayList<students> getStudents()
    {
        ArrayList<students> studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            students student = new students();
            student.StudentID = cursor.getInt(2);
            student.Name = cursor.getString(1);
            studentList.add(student);
        }
        return studentList;
    }

}
