package sg.edu.np.mad.madassignmentgrpanpaf;

public class Course {
    private String _courseId;
    private String _schoolId;
    private String _courseName;

    public Course() { }

    public Course(String courseId, String schoolId, String courseName) {
        this._courseId = courseId;
        this._schoolId = schoolId;
        this._courseName = courseName;
    }

    public void setCourseId(String courseId) {
        this._courseId = courseId;
    }
    public String getCourseId() {
        return this._courseId;
    }

    public void setSchoolId(String schoolId) {
        this._schoolId = schoolId;
    }
    public String getSchoolId() {
        return this._schoolId;
    }

    public void setCourseName(String courseName) { this._courseName = courseName; }
    public String getCourseName() {
        return _courseName;
    }


}
