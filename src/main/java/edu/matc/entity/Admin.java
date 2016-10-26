package edu.matc.entity;


import javax.persistence.*;

/**
 * Created by student on 10/25/16.
 */

@Entity
@Table(name = "Admin")
public class Admin {


    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "admin_level")
    private String admin_level;

    public Admin(){

    }

    public String getUser_id() {return user_id; }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAdmin_level() { return admin_level; }

    public void setAdmin_level() {
        this.admin_level = admin_level;
    }
}
