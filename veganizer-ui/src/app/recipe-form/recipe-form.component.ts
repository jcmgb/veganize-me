import { Component } from '@angular/core';
import {Recipe} from "../model/recipe";
import {ActivatedRoute, Router} from "@angular/router";
import {RecipeService} from "../service/recipe-service.service";

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.scss']
})
export class RecipeFormComponent {
  recipe: Recipe;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private recipeService: RecipeService) {
    this.recipe = new Recipe();
  }

  onSubmit() {
    this.recipeService.save(this.recipe).subscribe(result => this.gotToRecipeList());
  }

  gotToRecipeList() {
    this.router.navigate(['/recipes']);
  }
}
