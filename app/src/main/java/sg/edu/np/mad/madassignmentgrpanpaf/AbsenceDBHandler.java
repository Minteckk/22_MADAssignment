package sg.edu.np.mad.madassignmentgrpanpaf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class AbsenceDBHandler extends SQLiteOpenHelper {
    absent absents;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Absentees.db";
    // create a table called Absentees
    public static final String TABLE_ABSENTEES = "Absentees";

    // define a auto increment ID
    public static final String COLUMN_ID = "Id";

    // define column for student ID
    public static final String COLUMN_STUDENT_ID = "StudentID";

    // define column for student Class
    public static final String COLUMN_START_DATE = "StartDate";

    // define column for AttendanceStatus
    public static final String COLUMN_END_DATE = "EndDate";

    // define column for AttendanceStatus
    public static final String COLUMN_DATE_OF_ISSUE = "DateOfIssue";

    // define column for AttendanceStatus
    public static final String COLUMN_CLINIC_NAME = "ClinicName";

    // define column for AttendanceStatus
    public static final String COLUMN_CLINIC_NUMBER = "ClinicNumber";

    // define column for AttendanceStatus
    public static final String COLUMN_ABSENCE_REASON = "AbsenceReason";

    // define column for AttendanceStatus
    public static final String COLUMN_ABSENCE_FROM = "AbsenceFrom";

    public AbsenceDBHandler(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql command to create the table with ID and Name and StudentID

        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_ABSENTEES
                + "("
                + COLUMN_STUDENT_ID + " VARCHAR(8) PRIMARY KEY,"
                + COLUMN_START_DATE + " DATE(50) NOT NULL,"
                + COLUMN_END_DATE + " DATETIME(50) NOT NULL,"
                + COLUMN_DATE_OF_ISSUE + " DATE(50) NOT NULL," +
                  COLUMN_CLINIC_NAME + " TEXT(100) NOT NULL," +
                COLUMN_CLINIC_NUMBER + " INT(100) NOT NULL," +
                COLUMN_ABSENCE_REASON + " TEXT(100) NOT NULL," +
                COLUMN_ABSENCE_FROM + " TEXT(100) NOT NULL,"
                + "CONSTRAINT CK_" + COLUMN_STUDENT_ID + " CHECK(" + COLUMN_STUDENT_ID + " >= 10000000 AND " + COLUMN_STUDENT_ID + " <= 10999999)"
                + ")";
        // execute the command
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        //onCreate(db);
    }

    // method to add new student to database
        public void addNewAbsentRecord(absent absents) {
        // calls uploadStudent method
        ContentValues values = uploadAbsentReason(absents);
        // get Writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // insert into Students table
        db.insert(TABLE_ABSENTEES, null,values);
        // close the database connection
        db.close();

    }

    @NonNull
    // method to upload student to database
    private ContentValues uploadAbsentReason(absent absents)
    {
        ContentValues values = new ContentValues();
        // put student name into students table
        values.put(COLUMN_STUDENT_ID, absents.getStudentID());
        // put student id into students table
        values.put(COLUMN_START_DATE, absents.startDate);
        // put student class into students table
        values.put(COLUMN_END_DATE, absents.endDate);
        // put student attendance status into students table
        values.put(COLUMN_DATE_OF_ISSUE, absents.DateOfIssue);
        values.put(COLUMN_CLINIC_NAME,absents.ClinicNo);
        values.put(COLUMN_CLINIC_NUMBER,absents.ClinicNumber);
        values.put(COLUMN_ABSENCE_REASON,absents.AbsenceReason);
        values.put(COLUMN_ABSENCE_FROM,absents.AbsenceFrom);

        // return the value
        return values;
    }

    // method to retrieve students from database
    public ArrayList<absent> getAbsentees()
    {
        // initialize the arraylist
        ArrayList<absent> absenceList = new ArrayList<>();
        // sql statements to select from students table
        String query = "SELECT * FROM " + TABLE_ABSENTEES;
        // get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext())
        {
            absent absents = new absent();
            absents.StudentID = cursor.getString(0);
            absents.startDate = cursor.getString(1);
            absents.endDate = cursor.getString(2);
            absents.DateOfIssue = cursor.getString(3);
            absents.ClinicNo = cursor.getString(4);
            absents.ClinicNumber = cursor.getString(5);
            absents.AbsenceReason = cursor.getString(6);
            absents.AbsenceFrom = cursor.getString(7);

            absenceList.add(absents);
        }
        cursor.close();
        db.close();
        return absenceList;
    }
}
