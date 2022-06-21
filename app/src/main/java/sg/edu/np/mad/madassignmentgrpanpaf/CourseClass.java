package sg.edu.np.mad.madassignmentgrpanpaf;

public class CourseClass {
    private String _courseId;
    private int _classId;

    public CourseClass() { }

    public CourseClass(String courseId, int classId) {
        this._courseId = courseId;
        this._classId = classId;
    }

    public void setCourseId(String courseId) {
        this._courseId = courseId;
    }
    public String getCourseId() {
        return this._courseId;
    }

    public void setClassId(int classId) {
        this._classId = classId;
    }
    public int getClassId() {
        return this._classId;
    }

    public String getClassName() {
        return _courseId + _classId;
    }
}
