package com.example.rxjava.Model;

import java.util.ArrayList;
import java.util.List;

public class List_Users {

    public static List<Users> getUsers(){

        List<Users> users = new ArrayList<>();
        users.add(new Users("ava","ava@yahoo.com",1,true));
        users.add(new Users("ava","ava@yahoo.com",1,true));
        users.add(new Users("arash","arash@yahoo.com",2,true));
        users.add(new Users("arash","arash@yahoo.com",2,true));
        users.add(new Users("shahin","shahin@yahoo.com",3,false));
        users.add(new Users("shahla","shahla@yahoo.com",4,true));

        return users;
    }
}
