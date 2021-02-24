package com.przybylski.lamaniekodu.Controller.Hobby;

import com.przybylski.lamaniekodu.dao.hobby.CategoryDao;
import com.przybylski.lamaniekodu.model.Hobby.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/hobby/sport/form")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("category", new Category());
        return "hobby/sport/addCategory";
    }

    @PostMapping("hobby/sport/addCategory")
    public String create(@ModelAttribute Category category) {
        categoryDao.save(category);
        return "redirect:/hobby/sport/allCategory";
    }


    @GetMapping("/hobby/sport/allCategory")
    public String findAll(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryDao.findAll());
        return "hobby/sport/allCategory";
    }

    @GetMapping("/category/{id}")
    public String show(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("category", categoryDao.findById(id).get());
        return "category/show";
    }
}

