package com.sheryians.major.Controller;

import com.sheryians.major.Model.Category;
import com.sheryians.major.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/Admin")
    public String adminHome()
    {
        return "adminHome";
    }
// ----------------------------------------------------------------------------------------
    @GetMapping("/Admin/Catagories")
    public String adminCatagories(Model model)
    {
        model.addAttribute("categories", categoryService.findAllCategory());
        return "categories";
    }
    // ----------------------------------------------------------------------------------------
    @GetMapping("/Admin/Catagories/Add")
    public String getCatagoriesAdd(Model model)
    {
        model.addAttribute("category", new Category());
        return "categoriesAdd.html";
    }
    // ----------------------------------------------------------------------------------------
    @PostMapping("/Admin/Catagories/Add")
    public String postCatagoriesAdd(@ModelAttribute("category") Category category)
    {
        categoryService.AddCategory(category);
        return "redirect:/Admin/Catagories";
    }
    // ----------------------------------------------------------------------------------------
}
