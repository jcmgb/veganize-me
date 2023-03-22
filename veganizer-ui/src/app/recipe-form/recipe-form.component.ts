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
  }

  onSubmit() {
    this.recipeService.save(this.recipe).subscribe(result => {
      this.veganized = true;
      this.recipe = result;
    });
  }

  public veganizeRecipe(): void {
    this.recipe = new Recipe();
    this.veganized = false;
  }

  public copyRecipe() {
    return this.recipe.title + '\n' + this.recipe.veganized;
  }
}
