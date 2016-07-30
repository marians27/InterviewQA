export class Category {
    private name: string;
    private description: string;
    
    constructor(name: string, description: string) {
        this.name = name;
        this.description = description;
    }
    
    getName(): string {
        return this.name;
    }
}