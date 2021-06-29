package com.guideme;

import java.io.Serializable;

public class User implements Serializable {
    public String fullname;
    public String username;
    public String email;
    public double ftp;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String fullname, String username, String email, double ftp){
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.ftp = ftp;
    }

}
