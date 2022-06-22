package sg.edu.np.mad.madassignmentgrpanpaf;

public class School {
    private String _schoolId;
    private String _schoolName;

    public School(){}
    public School(String schoolId, String schoolName){
        this._schoolId = schoolId;
        this._schoolName = schoolName;
    }

    public void setSchoolId(String schoolId) {
        this._schoolId = schoolId;
    }
    public String getSchoolId() {
        return this._schoolId;
    }

    public void setSchoolName(String schoolName) { this._schoolName = schoolName; }
    public String getSchoolName() {
        return _schoolName;
    }
}
