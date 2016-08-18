package pl.iqa.repository;

import org.springframework.stereotype.Repository;
import pl.iqa.model.question.Category;
import pl.iqa.repository.exceptions.EntityExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
//TODO: mock implementation, provide real one
public class CategoryRepository {

    private ConcurrentHashMap<String, Category> categories = new ConcurrentHashMap<>();

    public List<Category> loadCategories() {
        return new ArrayList<>(categories.values());
    }

    public void createCategory(Category category) {
        if (categories.putIfAbsent(category.getName(), category) != null) {
            throw new EntityExistsException("Category with name " + category.getName() + " already exists");
        }
    }

    public void updateCategory(Category category) {
        categories.put(category.getName(), category);
    }

    public boolean exists(String categoryName) {
        return categories.containsKey(categoryName);
    }
}
