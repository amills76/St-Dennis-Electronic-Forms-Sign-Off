package edu.matc.entity;

import javax.persistence.*;

/**
 * A class to represent a login.
 *
 * @author Andy Mills
 */

@Entity
@Table(name = "login")
public class Login {

    @Id
    @Column(name = "loginId")
    private int loginId;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "password")
    private String password;

    @Column(name = "access_level")
    private String access_level;

public Login(){

}

    public int getLoginId() { return loginId; }

    public void setLoginId(int loginId) {
         this.loginId = loginId;
    }

    public String getUser_id() {return user_id; }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess_level() { return access_level; }

    public void setAccess_level() {
        this.access_level = access_level;
    }

}
