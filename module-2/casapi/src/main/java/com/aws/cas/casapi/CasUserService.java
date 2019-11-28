package com.aws.cas.casapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasUserService{

    public CasUser cuser;
    private CasUsers users;

    public void save(CasUsers casusers) {
        users = casusers;
    }

    public CasUsers getUsers() {
        return users;
    }

    public void save(CasUser cuserbean){
        cuser=cuserbean;
    }

    public CasUser getUserList(){

        return cuser;
    }
}