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
    public CasUser getAllUsers(HttpServletResponse response,@RequestParam(value = "filter", required = false) String filter,@RequestParam(value = "value", required = false) String value) 
    {
        response.addHeader("Access-Control-Allow-Origin", "*");
        
        CasUsers users;

        if (filter != null)
            users = CasUserService.queryUserItems(filter,value);
        else
            users = CasUserService.getUserList();

        return users;
        
    }
    
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /getuserlist instead.";
    }
}
