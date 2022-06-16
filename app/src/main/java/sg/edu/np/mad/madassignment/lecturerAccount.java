package sg.edu.np.mad.madassignment;

// class for lecturer login account
public class lecturerAccount {
    // initialize username and password variable
    String Username;
    String Password;

    public lecturerAccount(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public lecturerAccount(){};
    // method to set User name
    public void setUsername(String username) {this.Username = username;}
    // method to get User name
    public String getUsername(String username) {return this.Username;}
    // method to set Password
    public void setPassword(String password) {this.Password = password;}
    // method to get password
    public String getPassword(String password) {return this.Password;}
}
