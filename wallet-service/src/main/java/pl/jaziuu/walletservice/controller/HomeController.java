package pl.jaziuu.walletservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class HomeController {

    @GetMapping("/user")
    public String user(){
        return "HELLO USER";
    }

    @GetMapping("/admin")
    public String admin(){
        return "HELLO ADMIN";
    }

    @GetMapping("/mod")
    public String mod(){
        return "HELLO MODERATOR";
    }
}

