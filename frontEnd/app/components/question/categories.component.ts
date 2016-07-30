import {Component} from '@angular/core';
import {Category} from '../../model/category';
import {CategoryService} from '../../services/category.service';
import {EntityAlreadyExists} from '../../services/exceptions/entityAlreadyExists.exception';

@Component({
    selector: 'categories',
    templateUrl: 'app/templates/question/categories.html'
})
export class Categories {
    private categoryService: CategoryService;
    
    private categories: Array<Category>;
    private newCategory: Category = new Category("", "");
    private isNameValid: boolean = true;
    
    constructor(categoryService: CategoryService) {
        this.categories = categoryService.loadCategories();
        this.categoryService = categoryService;
    }
    
    addCategory(): void {
        if (!this.isAddPossible()) {
            return;
        }
        try {
            this.isNameValid = true;
            this.categoryService.addNewCategory(this.newCategory);
            this.newCategory = new Category("", "");
            this.categories = this.categoryService.loadCategories();
        } catch(e) {
            this.isNameValid = false;
        }
    }
    
    isAddPossible(): boolean {
        if (this.newCategory.getName() == null || this.newCategory.getName() == "") {
            return false;
        }
        return true;
    }
    
    nameChanged(): void {
        this.isNameValid = true;
    }
}