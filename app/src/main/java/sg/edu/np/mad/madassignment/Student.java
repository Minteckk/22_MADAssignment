package sg.edu.np.mad.madassignment;

//Start of Student Class

public class Student {
    private int _id;
    private String _name;
    private String _password;
    public Student() { }

    public Student(int id, String name, String password) {
        this._id = id;
        this._name = name;
        this._password = password;
    }
    public Student(int id, String password) {
        this._id = id;
        this._password = password;
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

    public void setPassword(String password) {
        this._password = password;
    }
    public String getPassword() {
        return this._password;
    }
}
//End of Student Class
