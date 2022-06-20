//Start Of Data Handler
package sg.edu.np.mad.madassignment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AccountDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accountDB.db";

    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENTID = "studentId";
    public static final String COLUMN_STUDENTNAME = "studentName";
    public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_STAFF = "staff";
    public static final String COLUMN_STAFFID = "staffId";
    public static final String COLUMN_STAFFNAME = "staffName";
    // public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_SCHOOL = "school";
    public static final String COLUMN_SCHOOLID = "schoolId";
    public static final String COLUMN_SCHOOLNAME = "schoolName";

    public static final String TABLE_COURSE = "course";
    public static final String COLUMN_COURSEID = "courseId";
    // public static final String COLUMN_SCHOOLID = "schoolId";
    public static final String COLUMN_COURSENAME = "courseName";

    public static final String TABLE_CLASS = "class";
    // public static final String COLUMN_COURSEID = "courseId";
    public static final String COLUMN_CLASSID = "classId";
    // public static final String COULNM_STUDENTID = "studentId";

    public static final String TABLE_ATTENDANCE = "attendance";
    // public static final String COLUMN_STUDENTID = "studentId";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_FEEDBACK = "feedback";

    public AccountDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Create Tables
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT
                + "("
                + COLUMN_STUDENTID + " INT PRIMARY KEY,"
                + COLUMN_STUDENTNAME + " VARCHAR(50),"
                + COLUMN_PASSWORD + " VARCHAR(50) NOT NULL,"
                + "CONSTRAINT CK_" + COLUMN_STUDENTID + " CHECK(" + COLUMN_STUDENTID + " >= 10000000 AND " + COLUMN_STUDENTID + " <= 10999999)"
                + ")";
        db.execSQL(CREATE_STUDENT_TABLE);

        for (int i = 10000000; i < 10000500; i++){
            Student s = new Student(i,"Name " + i, "password");
            this.addStudent(s);
        }

        String CREATE_STAFF_TABLE = "CREATE TABLE " + TABLE_STAFF
                + "("
                + COLUMN_STAFFID + " INT PRIMARY KEY,"
                + COLUMN_STAFFNAME + " VARCHAR(50),"
                + COLUMN_PASSWORD + " VARCHAR(50) NOT NULL"
                + ")";
        db.execSQL(CREATE_STAFF_TABLE);

        for (int i = 20000000; i < 20000100; i++){
            Staff s = new Staff(i,"Name " + i, "pass123");
            this.addStaff(s);
        }

        String CREATE_SCHOOL_TABLE = "CREATE TABLE " + TABLE_SCHOOL
                + "("
                + COLUMN_SCHOOLID + " VARCHAR(5) PRIMARY KEY,"
                + COLUMN_SCHOOLNAME + " VARCHAR(50) NOT NULL"
                + ")";
        db.execSQL(CREATE_SCHOOL_TABLE);
        ;
        School school = new School("ICT","School of InfoComm Technology");
        this.addSchool(school);


        String CREATE_COURSE_TABLE = "CREATE TABLE " + TABLE_COURSE
                + "("
                + COLUMN_COURSEID + " VARCHAR(5) PRIMARY KEY,"
                + COLUMN_SCHOOLID + " VARCHAR(5) NOT NULL,"
                + COLUMN_COURSENAME + " VARCHAR(50) NOT NULL,"
                + "CONSTRAINT FK_" + TABLE_COURSE + "_" + COLUMN_SCHOOLID + " FOREIGN KEY (" + COLUMN_SCHOOLID + ") REFERENCES " + TABLE_SCHOOL + "(" + COLUMN_SCHOOLID + ")"
                + ")";
        db.execSQL(CREATE_COURSE_TABLE);
        this.addCourse(new Course("IT","ICT","Information Technology"));
        this.addCourse(new Course("CSF","ICT","Cybersecurity & Digital Forensics"));
        this.addCourse(new Course("DS","ICT","Data Science"));
        this.addCourse(new Course("CICTP", "ICT","Common ICT Programme"));
        this.addCourse(new Course("IM","ICT","Immersive Media"));

        String CREATE_CLASS_TABLE = "CREATE TABLE " + TABLE_CLASS
                + "("
                + COLUMN_COURSEID + " VARCHAR(5) NOT NULL,"
                + COLUMN_CLASSID + " INT NOT NULL,"
                + COLUMN_STUDENTID + " INT UNIQUE NOT NULL,"
                + "CONSTRAINT PK_" + TABLE_CLASS + " PRIMARY KEY(" + COLUMN_COURSEID + ", " + COLUMN_CLASSID + "),"
                + "CONSTRAINT FK_" + TABLE_CLASS + "_" + COLUMN_COURSEID + " FOREIGN KEY (" + COLUMN_COURSEID + ") REFERENCES " + TABLE_COURSE + "(" + COLUMN_COURSEID + "),"
                + "CONSTRAINT FK_" + TABLE_CLASS + "_" + COLUMN_STUDENTID + " FOREIGN KEY (" + COLUMN_STUDENTID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_STUDENTID + ")"
                + ")";
        db.execSQL(CREATE_CLASS_TABLE);
        List<String> schId = Arrays.asList("IT","CSF","DS","CICTP","IM");
        for (String id : schId) {
            for(int i = 1; i <= 5; i++) {
                for (int j = (i - 1) * 20 + 10000000; j < i * 20 + 10000000; j++ )
                this.addClass(new CourseClass(id, i),j);
            }
        }

        String CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + TABLE_ATTENDANCE
                + "("
                + COLUMN_STUDENTID + " INT NOT NULL,"
                + COLUMN_DATE + " DATE NOT NULL,"
                + COLUMN_FEEDBACK + " VARCHAR(1500),"
                + "CONSTRAINT PK_" + TABLE_ATTENDANCE + " PRIMARY KEY(" + COLUMN_STUDENTID + ", " + COLUMN_DATE + "),"
                + "CONSTRAINT FK_" + TABLE_ATTENDANCE + "_" + COLUMN_STUDENTID + " FOREIGN KEY (" + COLUMN_STUDENTID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_STUDENTID + ")"
                + ")";
        db.execSQL(CREATE_ATTENDANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Insert or Delete Data
    }


    public boolean checkAttendance(int studentId, String ddMMyyyy) {
        String query = "SELECT * FROM " + TABLE_ATTENDANCE
                + " WHERE " + COLUMN_STUDENTID + " = " + studentId
                + " AND " + COLUMN_DATE + " = " + "\"" + ddMMyyyy + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public void updateAttendance(int studentId, String ddMMyyyy, boolean status){
        SQLiteDatabase db = this.getWritableDatabase();

        if (checkAttendance(studentId, ddMMyyyy)){
            if (!status){
                String DELETE_ATTENDANCE_TUPLE = "DELETE FROM " + TABLE_ATTENDANCE
                        + " WHERE " + COLUMN_STUDENTID + " = " + studentId
                        + " AND " + COLUMN_DATE + " = " + "\"" + ddMMyyyy + "\"";
                db.execSQL(DELETE_ATTENDANCE_TUPLE);
            }
        }
        else {
            if (status) {
                String INSERT_ATTENDANCE_TUPLE = "INSERT INTO " + TABLE_ATTENDANCE
                        + " VALUES (" + studentId + ", " + ddMMyyyy + ", NULL)";
                db.execSQL(INSERT_ATTENDANCE_TUPLE);
            }
        }
    }

    public void giveFeedback(int studentId, String ddMMyyyy, String feedback){
        SQLiteDatabase db = this.getWritableDatabase();
        if (checkAttendance(studentId, ddMMyyyy)){
            String UPDATE_ATTENDANCE_FEEDBACK = "UPDATE " + TABLE_ATTENDANCE
                    + " SET " + COLUMN_FEEDBACK  + " = " + "\"" + feedback + "\""
                    + " WHERE " + COLUMN_STUDENTID + " = " + studentId
                    + " AND " + COLUMN_DATE + " = " + "\"" + ddMMyyyy + "\"";
            db.execSQL(UPDATE_ATTENDANCE_FEEDBACK);
        }
    }

    public void updateStudentPassword(int studentId, String oldPassword, String newPassword){
        SQLiteDatabase db = this.getWritableDatabase();

        if (checkStudentPassword(studentId, oldPassword)) {
            String UPDATE_STUDENT_PASSWORD = "UPDATE " + TABLE_STUDENT
                    + " SET " + COLUMN_PASSWORD + " = " + "\"" + newPassword + "\""
                    + " WHERE " + COLUMN_STUDENTID + " = " + studentId;
            db.execSQL(UPDATE_STUDENT_PASSWORD);
        }
    }

    public void updateStaffPassword(int staffId, String oldPassword, String newPassword){
        SQLiteDatabase db = this.getWritableDatabase();

        if (checkStaffPassword(staffId, oldPassword)) {
            String UPDATE_STAFF_PASSWORD = "UPDATE " + TABLE_STAFF
                    + " SET " + COLUMN_PASSWORD + " = " + "\"" + newPassword + "\""
                    + " WHERE " + COLUMN_STAFFID + " = " + staffId;
            db.execSQL(UPDATE_STAFF_PASSWORD);
        }
    }


    public void addStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENTID, student.getId());
        values.put(COLUMN_STUDENTNAME, student.getName());
        values.put(COLUMN_PASSWORD, student.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_STUDENT, null, values);
        db.close();
    }

    public void addStaff(Staff staff) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_STAFFID, staff.getId());
        values.put(COLUMN_STAFFNAME, staff.getName());
        values.put(COLUMN_PASSWORD, staff.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.insert(TABLE_STAFF, null, values);
        db.close();
    }

    public void addSchool(School school) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCHOOLID, school.getSchoolId());
        values.put(COLUMN_SCHOOLNAME, school.getSchoolName());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_SCHOOL, null, values);
        db.close();
    }

    public void addCourse(Course course) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSEID, course.getCourseId());
        values.put(COLUMN_COURSENAME, course.getCourseName());
        values.put(COLUMN_SCHOOLID, course.getSchoolId());
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_COURSE, null, values);
        db.close();
    }

    public void addClass(CourseClass courseClass, int studentId){
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSEID, courseClass.getCourseId());
        values.put(COLUMN_CLASSID, courseClass.getClassId());
        values.put(COLUMN_STUDENTID, studentId);
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_CLASS, null, values);
        db.close();
    }

    public Student findStudent(int id) {
        String query = "SELECT " + "*" + " FROM " + TABLE_STUDENT + " WHERE " + COLUMN_STUDENTID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student();

        if (cursor.moveToFirst()) {
            student.setStudentId(Integer.parseInt(cursor.getString(0)));
            student.setName(cursor.getString(1));
            student.setPassword(cursor.getString(2));
            cursor.close();
        }
        else {
            student = null;
        }
        db.close();
        return student;
    }

    public Staff findStaff(int id) {
        String query = "SELECT " + "*" + " FROM " + TABLE_STAFF + " WHERE " + COLUMN_STAFFID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Staff staff = new Staff();

        if (cursor.moveToFirst()) {
            staff.setId(Integer.parseInt(cursor.getString(0)));
            staff.setName(cursor.getString(1));
            staff.setPassword(cursor.getString(2));
            cursor.close();
        }
        else {
            staff = null;
        }
        db.close();
        return staff;
    }

    public boolean checkStudentPassword(int id, String password){
        //Check if student
        if (findStudent(id) != null){
            return findStudent(id).getPassword().equals(password);
        }
        return false; //invalid student id entered
    }

    public boolean checkStaffPassword(int id, String password){
        //Check if staff
        if (findStaff(id) != null){
            return findStaff(id).getPassword().equals(password);
        }
        return false; //invalid staff id entered
    }

    public List<Student> getStudentListOfClass(String courseId, int classId){
        String query = "SELECT " + COLUMN_STUDENTID + " FROM " + TABLE_CLASS
                + " WHERE " + COLUMN_COURSEID + " = " + "\"" + courseId + "\""
                + " AND " + COLUMN_CLASSID + " = " + classId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<Student> studentList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                studentList.add(findStudent(Integer.parseInt(cursor.getString(0))));
            } while (cursor.moveToNext());
            cursor.close();
            return studentList;
        }
        cursor.close();
        return null;
    }

    public List<CourseClass> getClassListOfCourse(String courseId){
        String query = "SELECT " + COLUMN_COURSEID + ", " + COLUMN_CLASSID + " FROM " + TABLE_CLASS
                + " WHERE " + COLUMN_COURSEID + " = " + "\"" + courseId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<CourseClass> classList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                classList.add(new CourseClass(cursor.getString(0), Integer.parseInt(cursor.getString(1))));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return classList;
    }

    public List<Course> getCourseListOfSchool(String schoolId) {
        String query = "SELECT " + "*" + " FROM " + TABLE_COURSE
                + " WHERE " + COLUMN_SCHOOLID + " = " + "\"" + schoolId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<Course> courseList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                courseList.add(new Course(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return courseList;
    }

    public List<School> getSchoolList(){
        String query = "SELECT " + "*" + " FROM " + TABLE_SCHOOL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        List<School> schoolList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                schoolList.add(new School(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return schoolList;
    }

    /*
    public String getCourseNameByCourseId(String courseId){
        String query = "SELECT " + COLUMN_COURSENAME + " FROM " + TABLE_COURSE + " WHERE " + COLUMN_COURSEID + " = " + courseId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return cursor.getString(0);
        }

        return null;
    }

    public String getCourseNameByStudentId(int studentId){
        String query = "SELECT " + COLUMN_COURSEID + " FROM " + TABLE_CLASS + " WHERE " + COLUMN_STUDENTID + " = " + studentId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return getCourseNameByCourseId(cursor.getString(0));
        }

        return null;
    }

    public String getSchoolNameBySchoolId(String schoolId){
        String query = "SELECT " + COLUMN_SCHOOLNAME + " FROM " + TABLE_SCHOOL + " WHERE " + COLUMN_SCHOOLID + " = " + "\"" + schoolId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return cursor.getString(0);
        }

        return null;
    }
}
    /*
    public String getSchoolNameByCourseId(String courseId){
        String query = "SELECT " + COLUMN_SCHOOLID + " FROM " + TABLE_COURSE + " WHERE " + COLUMN_COURSEID + " = " + "\"" + courseId + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return getSchoolNameBySchoolId(cursor.getString(0));
        }

        return null;
    }

    public String getSchoolNameByStudentId(int studentId){
        String query = $"SELECT {COLUMN_COURSEID} FROM {TABLE_CLASS} "
                + $"WHERE {COLUMN_STUDENTID} = {studentId}";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return getSchoolNameByCourseId(cursor.getString(0));
        }

        return null;
    }

    public String getStudentNameByStudentId(int studentId){
        String query = $"SELECT {COLUMN_STUDENTNAME} FROM {TABLE_STUDENT} "
                + $"WHERE {COLUMN_STUDENTID} = \"{studentId}\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return cursor.getString(0);
        }

        return null;
    }

    public String getClassNameByStudentId(int studentId){
        String query = $"SELECT {COLUMN_COURSEID}, {COLUMN_CLASSID} FROM {TABLE_CLASS} "
                + $"WHERE {COLUMN_STUDENTID} = \"{studentId}\"";\

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return cursor.getString(0) + "0" + cursor.getString(1);
        }

        return null;
    }

    public List<String> getClassListBy

     */
}
//End of Data Handler

