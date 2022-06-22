package sg.edu.np.mad.madassignmentgrpanpaf;

public class Staff {
    private int _staffId;
    private String _name;
    private String _password;
    public Staff() { }

    public Staff(int staffId, String name, String password) {
        this._staffId = staffId;
        this._name = name;
        this._password = password;
    }
    public Staff(int staffId, String password) {
        this._staffId = staffId;
        this._password = password;
    }

    public void setId(int staffId) {
        this._staffId = staffId;
    }
    public int getId() {
        return this._staffId;
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
