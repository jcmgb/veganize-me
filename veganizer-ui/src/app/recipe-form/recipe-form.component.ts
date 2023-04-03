import {Component, OnInit} from '@angular/core';
import {Recipe} from '../model/recipe';
import {ActivatedRoute, Router} from '@angular/router';
import {RecipeService} from '../service/recipe.service';
import {FormControl, FormGroup} from '@angular/forms';

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
  public veganizedContent = [];
  public recipeSteps = [];

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
    this.veganizeRecipe();
  }

  onSubmit() {
    this.attemptedTitle = this.recipe.title;
    this.isTitleUnique = true;
    this.recipeService.save(this.recipe).subscribe(
      result => {
        this.veganized = true;
        this.recipe = result;
        this.veganizedContent = this.recipe.veganized.split('\n');
        this.recipeSteps = this.recipe.steps.split('\n');
      },
      error => {
      if (error.error.message.toLowerCase().includes('title already exists')) {
        this.isTitleUnique = false;
      }
      throw 'Error in source. Details: ' + error;
    });
  }

  public isDuplicate(formTitle: string): boolean {
    return (!this.isTitleUnique && this.attemptedTitle === formTitle) ? true : false;
  }

  public veganizeRecipe(): void {
    this.recipe = new Recipe();
    this.veganized = false;
    this.isTitleUnique = true;
    this.attemptedTitle = null;
    this.veganizedContent = [];
  }

  public copyRecipe(): string {
    return this.recipe.title + '\n' + this.recipe.veganized + '\n' + this.recipe.steps;
  }

  public clearRecipeForm(): void {
    this.recipe = new Recipe();
    this.recipeService.save(this.recipe).subscribe(
      result => {
        this.veganized = true;
        this.recipe = result;
      });
  }
}
