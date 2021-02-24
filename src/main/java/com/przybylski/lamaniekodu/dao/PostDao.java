package com.przybylski.lamaniekodu.dao;

import com.przybylski.lamaniekodu.model.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostDao extends CrudRepository<Post, Integer> {
}
