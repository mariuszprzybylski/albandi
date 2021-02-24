package com.przybylski.lamaniekodu.Controller.Hobby;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HobbyController {

    @GetMapping("/hobby/firstPage")
    public String firstPage(Model model){return "hobby/firstPage";}
}
