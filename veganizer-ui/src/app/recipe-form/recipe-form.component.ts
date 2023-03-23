import {Component, OnInit} from '@angular/core';
import {Recipe} from '../model/recipe';
import {ActivatedRoute, Router} from '@angular/router';
import {RecipeService} from '../service/recipe-service.service';

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.scss']
})
export class RecipeFormComponent implements OnInit {
  public recipe: Recipe;

  public veganized: boolean;
  public isTitleUnique: boolean;
  public attemptedTitle: string;

  public ingredientsPlaceholder: string = "Enter the recipe ingredients list. For example:\n\n" +
    "2 cups flour\n" +
    "1 egg\n" +
    "1 stick butter, softened";

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.recipe = new Recipe();
    this.veganized = false;
    this.isTitleUnique = true;
    this.attemptedTitle = null;
  }

  onSubmit() {
    this.attemptedTitle = this.recipe.title;
    this.recipeService.save(this.recipe).subscribe(
      result => {
      this.veganized = true;
      this.recipe = result;
    },
      error => {
      if (error.error.message.toLowerCase().includes('title already exists')) {
        this.isTitleUnique = false;
      }
      throw 'Error in source. Details: ' + error;
    })
  }

  public isDuplicate(formTitle: string): boolean {
    let check =  (!this.attemptedTitle || !formTitle) ? false :
      (this.attemptedTitle === formTitle) ? true  : false;
    return check;
  }

  public veganizeRecipe(): void {
    this.recipe = new Recipe();
    this.veganized = false;
    this.isTitleUnique = true;
    this.attemptedTitle = null;
  }

  public copyRecipe() {
    return this.recipe.title + '\n' + this.recipe.veganized;
  }
}
