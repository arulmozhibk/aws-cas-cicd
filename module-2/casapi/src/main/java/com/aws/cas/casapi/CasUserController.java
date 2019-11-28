package com.aws.cas.casapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CasUserController {


    @Autowired
    private CasUserService casUserService = new CasUserService();

    @RequestMapping(value="/getuserlist", method= RequestMethod.GET)
    public CasUser getAllUsers(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return casUserService.getUserList();
    }
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /mysfits instead.";
    }
}
