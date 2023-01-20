
package DT;

public class Account {
    private String userName;
    private String password;
    private String linkAvatar;
    public Account(){
        userName = " ";
        password = " ";
        linkAvatar = "avatar1.jpg";
    }
    
    public Account(String username, String pass, String avatar){
        userName = username;
        password = pass;
        linkAvatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }
    
    public void setAvatar(String avatar){
        linkAvatar = avatar;
    }
    
    public String getAvatar(){
        return linkAvatar;
    }
}
