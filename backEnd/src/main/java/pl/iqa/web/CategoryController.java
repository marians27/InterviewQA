package pl.iqa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.iqa.model.question.Category;
import pl.iqa.services.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.retrieveCategories();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createCategory(@RequestBody @Valid Category category) {
        categoryService.createCategory(category);
    }

    @RequestMapping(value = "/{categoryName}", method = RequestMethod.PUT)
    public void updateCategory(@PathVariable String categoryName, @RequestBody @Valid Category category) {
        categoryService.updateCategory(categoryName, category);
    }
}
