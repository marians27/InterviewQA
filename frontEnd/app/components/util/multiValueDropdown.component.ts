import {Component, Input} from '@angular/core';

@Component({
    selector: 'multi-value-dropdown',
    templateUrl: 'app/templates/util/multiValueDropdown.html'
})
export class MultiValueDropdown {
    @Input() availableValues: Array<string>;
    @Input() prompt: string;
    @Input() selectedValues: Array<string>;
    
    private currentValue: string = null;
    
    addSelectedValue() : void {
        this.selectedValues.push(this.currentValue);
    }
    
    isFirstItem(): boolean {
        if (this.currentValue == null) {
            return true;
        }
        return false;
    }
    
    removeSelectedValue(value: string): void {
        this.removeFromArray(this.selectedValues, value);
        this.currentValue = undefined;
    }
    
    isSelected(value: string): boolean {
        if (this.selectedValues.indexOf(value) > -1) {
            return true;
        }
        return false;
    }
    
    private removeFromArray(array: Array<string>, value: string) {
        let index: number = array.indexOf(value);
        if (index > -1) {
            array.splice(index, 1);
        }
    }
}