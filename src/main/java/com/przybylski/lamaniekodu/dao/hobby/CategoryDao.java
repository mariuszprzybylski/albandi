package com.przybylski.lamaniekodu.dao.hobby;

import com.przybylski.lamaniekodu.model.Hobby.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {

}
