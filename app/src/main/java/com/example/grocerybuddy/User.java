package com.example.test;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {

    private String uname;
    private String password;
    private String fname;
    private String lname;
    private String filename = "user_file";
    private boolean logged;

    public void login(String user, String pass, Context context) {

        try {
            FileInputStream fis = context.openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(fis)));

            String data = reader.readLine();
            if(data != uname) {
                logged = false;
            }
            data = reader.readLine();
            if(data != password) {
                logged = false;
            }
            else {
                logged = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void signUp(String user, String pass, String first, String last, Context context) throws IOException {

        uname = user + "\n";
        password = pass + "\n";
        fname = first + "\n";
        lname = last + "\n";

        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(uname.getBytes());
        fos.write(password.getBytes());
        fos.write(fname.getBytes());
        fos.write(lname.getBytes());
        fos.close();

    }

    public String getFname(String user) {
        return this.fname;
    }

    public String getLname(String user) {
        return this.lname;
    }

    public boolean isLogged() { return logged; }
}