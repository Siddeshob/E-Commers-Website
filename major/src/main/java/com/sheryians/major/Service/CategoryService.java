package com.sheryians.major.Service;

import com.sheryians.major.Model.Category;
import com.sheryians.major.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void AddCategory(Category category)
    {
        categoryRepository.save(category);
    }

    public List<Category> findAllCategory()
    {
        return categoryRepository.findAll();
    }
}
