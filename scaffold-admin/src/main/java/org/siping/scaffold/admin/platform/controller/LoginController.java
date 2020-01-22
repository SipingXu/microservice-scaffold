package org.siping.scaffold.admin.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Siping
 */
@Controller
public class LoginController {

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

}
