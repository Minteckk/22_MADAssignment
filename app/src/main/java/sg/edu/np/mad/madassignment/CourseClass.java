package sg.edu.np.mad.madassignment;

public class CourseClass {
    private String _courseId;
    private int _classId;

    public CourseClass() { }

    public CourseClass(String courseId, int classId) {
        this._courseId = courseId;
        this._classId = classId;
    }

    public void setId(int id) {
        this._id = id;
    }
    public int getId() {
        return this._id;
    }

    public void setName(String name) {
        this._name = name;
    }
    public String getName() {
        return this._name;
    }

    public void setSchoolId(String schoolId) {
        this._schoolId = schoolId;
    }
    public String getSchoolId() {
        return this._schoolId;
    }
}
