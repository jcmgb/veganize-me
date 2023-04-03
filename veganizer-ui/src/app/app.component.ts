import {Component, OnInit, ViewChild} from '@angular/core';
import {RecipeListComponent} from './recipe-list/recipe-list.component';
import {RecipeFormComponent} from './recipe-form/recipe-form.component';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  @ViewChild('recipeListChild', { static: true })
  recipeListComponent: RecipeListComponent;

  @ViewChild('recipeFormChild', { static: true })
  recipeFormComponent: RecipeFormComponent;

  title = 'Veganize Me!';

  ngOnInit() {
    this.loadAllRecipes();
  }

  public loadAllRecipes(): void {
      this.recipeListComponent.ngOnInit();
  }

  public veganizeNewRecipe(): void {
    this.recipeFormComponent.veganizeRecipe();
  }
}
