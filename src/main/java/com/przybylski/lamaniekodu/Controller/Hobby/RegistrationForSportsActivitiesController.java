package com.przybylski.lamaniekodu.Controller.Hobby;

import com.przybylski.lamaniekodu.dao.hobby.CategoryDao;
import com.przybylski.lamaniekodu.dao.hobby.RegistrationForSportsActivitiesDao;
import com.przybylski.lamaniekodu.model.Hobby.RegistrationForSportsActivities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationForSportsActivitiesController {

    @Autowired
    private RegistrationForSportsActivitiesDao registrationForSportsActivitiesDao;

    @Autowired
    private CategoryDao categoryDao;


    @GetMapping("/hobby/sport/registration")
    public String registrationUser(ModelMap modelMap){
        modelMap.put("registration", new RegistrationForSportsActivities());
        modelMap.put("categories", categoryDao.findAll());
        return "hobby/sport/registration";
    }

    @PostMapping("hobby/sport/registration")
    public String save(@ModelAttribute RegistrationForSportsActivities registrationForSportsActivities, ModelMap modelMap){
        modelMap.put("registration", registrationForSportsActivities);
        registrationForSportsActivitiesDao.save(registrationForSportsActivities);
        return "hobby/sport/showUser";
    }

}