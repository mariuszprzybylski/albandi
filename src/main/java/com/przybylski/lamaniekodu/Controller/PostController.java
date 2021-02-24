package com.przybylski.lamaniekodu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.przybylski.lamaniekodu.dao.PostDao;
import com.przybylski.lamaniekodu.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PostController {

    @Autowired
    private PostDao postDao;

    @GetMapping("/post/add")
    public String add(ModelMap modelMap){
        modelMap.put("post", new Post());
        return "post/add";
    }

    @PostMapping("/post/add")
    public String create(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/post/all";
    }


    @GetMapping("/post/all")
    public String findAll(ModelMap modelMap) {
        modelMap.addAttribute("posts", postDao.findAll());
        return "post/all";
    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("post", postDao.findById(id).get());
        return "post/comment";
    }

    @GetMapping("post/remove/{id}")
    public String remove(@ModelAttribute Post post) {
        postDao.deleteById(post.getId());
        return "redirect:/post/all";
    }
}