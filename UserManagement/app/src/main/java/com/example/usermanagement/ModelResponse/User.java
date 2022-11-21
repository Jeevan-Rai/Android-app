package com.example.usermanagement.ModelResponse;

public class User {
    int id;
    String uname, email;

    public User(int id, String uname, String email) {
        this.id = id;
        this.uname = uname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
