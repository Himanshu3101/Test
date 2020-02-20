package com.himanshu.test;

public class User {
    private String uName;
    private String uAge;
//    private String Status;

    User(String Name, String Age){
        uName= Name;
        uAge= Age;
    }

    public String getuName() {
        if(uName == null){
            return "";
        }
        return uName;
    }

    public String getuAge() {
        if(uAge == null){
            return "";
        }
        return uAge;
    }
}
