package com.example.springdemo1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class HelloController {
//
////    @GetMapping("/")
////    public String sayHello() {
////        return "Hello Akshay, Spring Boot is alive.";
////    }
//
//    @GetMapping("/test")
//    public String sayRamRam(){
//        return ("Hello Mitrr Ram Ram");
//    }
//
//    @RequestMapping("req")
//    public String what(){
//        return "index";
//    }
//
//}
//@Controller
//public class HelloController{
//
//
//
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "about";
//    }
//
//    @GetMapping("/contact")
//    public String contact() {
//        return "contact";
//    }
//}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password) {

        // Fake authentication for now
        if (username.equals("admin") && password.equals("1234")) {
            return "redirect:/home";
        }

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}

