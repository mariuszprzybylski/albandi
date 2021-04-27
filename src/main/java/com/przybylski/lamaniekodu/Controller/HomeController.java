package com.przybylski.lamaniekodu.Controller;

import com.przybylski.lamaniekodu.dao.PostDao;
import com.przybylski.lamaniekodu.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private PostDao postDao;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @PostMapping("/failLogin")
    public String loginPageError(){
         return "fragments/loginPageError";
    }






}
