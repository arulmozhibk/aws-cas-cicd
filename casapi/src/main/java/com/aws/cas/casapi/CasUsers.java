package com.aws.cas.casapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
public class CasUsers{
    public List<CasUser> casUserList;

    @Override
    public String toString() {
        return "CasUsers{" +
                "CasUsers=" + casUserList +
                '}';
    }

    public List<CasUser> getCasUsers() {
        return casUserList;
    }

    public void setCasUsers(List<CasUser> userlist) {
        this.casUserList = userlist;
    }

    public CasUsers(List<CasUser> userlist) {
        this.casUserList = userlist;
    }

    public CasUsers() {}

}