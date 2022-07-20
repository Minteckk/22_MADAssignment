package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class P01Handler extends SQLiteOpenHelper {
    attendance feedback;
    private static final int DATABASE_VERSION = 21;
    private static final String DATABASE_NAME = "students.db";
    // create a table called Students
    public static final String TABLE_STUDENTS = "Students";

    // define a auto increment ID
    public static final String COLUMN_ID = "Id";

    // define column name
    public static final String COLUMN_NAME = "Name";

    // define column for student ID
    public static final String COLUMN_STUDENT_ID = "StudentID";

    // define column for student Class
    public static final String COLUMN_STUDENT_CLASS = "StudentClass";

    // define column for AttendanceStatus
    public static final String COLUMN_ATTENDANCE_STATUS = "AttendanceStatus";

    public static final String TABLE_ATTENDANCE = "attendance";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_FEEDBACK = "feedback";



    public P01Handler(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql command to create the table with ID and Name and StudentID

        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENTS
                + "("
                + COLUMN_STUDENT_ID + " VARCHAR(8) PRIMARY KEY,"
                + COLUMN_NAME + " VARCHAR(50) NOT NULL,"
                + COLUMN_STUDENT_CLASS + " VARCHAR(50) NOT NULL,"
                + COLUMN_ATTENDANCE_STATUS + " CHAR(1),"
                + "CONSTRAINT CK_" + COLUMN_STUDENT_ID + " CHECK(" + COLUMN_STUDENT_ID + " >= 10000000 AND " + COLUMN_STUDENT_ID + " <= 10999999)"
                + ")";
        // execute the command
        db.execSQL(CREATE_STUDENT_TABLE);

        String CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + TABLE_ATTENDANCE
                + "("
                + COLUMN_STUDENT_ID + " VARCHAR(8) NOT NULL,"
                + COLUMN_DATE + " DATE NOT NULL,"
                + COLUMN_FEEDBACK + " VARCHAR(1500),"
                + "CONSTRAINT PK_" + TABLE_ATTENDANCE + " PRIMARY KEY(" + COLUMN_STUDENT_ID + ", " + COLUMN_DATE + "),"
                + "CONSTRAINT FK_" + TABLE_ATTENDANCE + "_" + COLUMN_STUDENT_ID + " FOREIGN KEY (" + COLUMN_STUDENT_ID + ") REFERENCES " + TABLE_STUDENTS + "(" + COLUMN_STUDENT_ID + ")"
                + ")";
        db.execSQL(CREATE_ATTENDANCE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        //onCreate(db);
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
        // put student class into students table
        values.put(COLUMN_STUDENT_CLASS, student.getStudentClass());
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
            student.StudentClass = cursor.getString(2);
            student.AttendanceStatus = cursor.getExtras().getBoolean("3",false);
            student.StudentID = cursor.getString(0);
            student.Name = cursor.getString(1);
            studentaList.add(student);
        }
        cursor.close();
        db.close();
        return studentaList;
    }

    // method to retrieve students from database
    public ArrayList<students> getStudentsByClass(String StudentClass)
    {
        // initialize the arraylist
        ArrayList<students> classList = new ArrayList<>();
        // sql statements to select from students table
        String query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE "
                + COLUMN_STUDENT_CLASS
                + " = \"" + StudentClass + "\"";
        // get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            students student = new students();
            //student.StudentID = cursor.getString(0);
            student.setStudentClass(cursor.getString(2));
            student.setAttendanceStatus(cursor.getExtras().getBoolean("3",false));
            student.SetStudentID(cursor.getString(0));
            student.setName(cursor.getString(1));
            classList.add(student);
        }
        cursor.close();
        db.close();
        return classList;
    }

    public boolean checkAttendance(int studentId, String ddMMyyyy) {
        String query = "SELECT * FROM " + TABLE_ATTENDANCE
                + " WHERE " + COLUMN_STUDENT_ID + " = " + studentId
                + " AND " + COLUMN_DATE + " = " + "\"" + ddMMyyyy + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public void updateAttendance(String studentId,String status){
        SQLiteDatabase db = this.getWritableDatabase();

            String UPDATE_ATTENDANCE = "UPDATE " + TABLE_STUDENTS
                    + " SET " + COLUMN_ATTENDANCE_STATUS  + " = " + "\"" + status + "\""
                    + " WHERE " + COLUMN_STUDENT_ID + " = " + studentId;
            db.execSQL(UPDATE_ATTENDANCE);

        db.close();
    }


    public void giveFeedback(int studentId, String ddMMyyyy, String feedback){
        SQLiteDatabase db = this.getWritableDatabase();
        if (checkAttendance(studentId, ddMMyyyy)){
            String UPDATE_ATTENDANCE_FEEDBACK = "UPDATE " + TABLE_ATTENDANCE
                    + " SET " + COLUMN_FEEDBACK  + " = " + "\"" + feedback + "\""
                    + " WHERE " + COLUMN_STUDENT_ID + " = " + studentId
                    + " AND " + COLUMN_DATE + " = " + "\"" + ddMMyyyy + "\"";
            db.execSQL(UPDATE_ATTENDANCE_FEEDBACK);
        }
        db.close();
    }

    // method to retrieve feedback from database
    public ArrayList<attendance> getFeedback()
    {
        // initialize the arraylist
        ArrayList<attendance> feedbackList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        // sql statements to select from attendance table
        String query = "SELECT * FROM " + TABLE_ATTENDANCE;
        // get writable database
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            feedback = new attendance();
            feedback.setStudentId(cursor.getString(0));
            feedback.setDate(cursor.getString(1));
            feedback.setFeedback(cursor.getString(2));
            cursor.close();
        }
        else {
            feedback = null;
        }
        db.close();
        return feedbackList;
    }

    // method to retrieve feedback from database
    public ArrayList<attendance> FindFeedbackByStudentID(String studentId)
    {
        // initialize the arraylist
        ArrayList<attendance> feedbackList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        // sql statements to select from attendance table
        String query = "SELECT * FROM " + TABLE_ATTENDANCE + " WHERE "
                + COLUMN_STUDENT_ID
                + " = \"" + studentId + "\"";
        // get writable database

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            feedback = new attendance();
            feedback.setStudentId(cursor.getString(0));
            feedback.setDate(cursor.getString(1));
            feedback.setFeedback(cursor.getString(2));
            feedbackList.add(feedback);
        }
        cursor.close();
        db.close();
        return feedbackList;
    }

    public void addFeedback(attendance feedback) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENT_ID, feedback.getStudentId());
        values.put(COLUMN_DATE, feedback.getDate());
        values.put(COLUMN_FEEDBACK, feedback.getFeedback());
        //SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ATTENDANCE, null, values);
        db.close();
    }
}
