package pl.iqa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.iqa.model.question.Category;
import pl.iqa.repository.CategoryRepository;
import pl.iqa.services.exception.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> retrieveCategories() {
        return categoryRepository.loadCategories();
    }

    public void createCategory(Category category) {
        categoryRepository.createCategory(category);
    }

    public void updateCategory(String categoryName, Category category) {
        if (!categoryRepository.exists(categoryName)) {
            throw new EntityNotFoundException("Category " + categoryName + " does not exists");
        }
        if (!categoryName.equals(category.getName())) {
            throw new UnsupportedOperationException("Category rename is not supported");
        }
        categoryRepository.updateCategory(category);
    }

    public List<String> notExistingCategories(List<String> categoryNames) {
        return categoryNames.stream()
                .filter(categoryName -> !categoryRepository.exists(categoryName))
                .collect(Collectors.toList());
    }
}
