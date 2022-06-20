package sg.edu.np.mad.madassignment;

public class Student {
    private int _studentId;
    private String _name;
    private String _password;
    public Student() { }

    public Student(int studentId, String name, String password) {
        this._studentId = studentId;
        this._name = name;
        this._password = password;
    }
    public Student(int studentId, String password) {
        this._studentId = studentId;
        this._password = password;
    }

    public void setStudentId(int studentId) {
        this._studentId = studentId;
    }
    public int getId() {
        return this._studentId;
    }

    public void setName(String name) {
        this._name = name;
    }
    public String getName() {
        return this._name;
    }

    public void setPassword(String password) {
        this._password = password;
    }
    public String getPassword() {
        return this._password;
    }
}

