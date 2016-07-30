import {Injectable} from '@angular/core';
import {Category} from '../model/category';
import {EntityAlreadyExists} from './exceptions/EntityAlreadyExists.exception';

@Injectable()
export class CategoryService {
    private categories: Array<Category> = [
        new Category("Java", "General questions about Java"),
            new Category("JVM", "Questions about Java Virtual Maschine"),
            new Category("Programming", "Questions about programming in general"),
            new Category("Patterns", "Design patterns"),
            new Category("Spring", "Everything about spring framework")
    ];
    
    loadCategories(): Array<Category> {
        return this.categories;
    }
    
    addNewCategory(category: Category): void {
        for(let cat of this.categories) {
            if (cat.getName() == category.getName()) {
                throw new EntityAlreadyExists("category.name", cat.getName());
            }
        }
        this.categories.push(category);
        console.log(JSON.stringify(category));
    }
}