import {Component, OnInit} from '@angular/core';
import {Recipe} from '../model/recipe';
import {RecipeService} from '../service/recipe.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {
  recipes: Recipe[] = [];
  loading: boolean = true;

  constructor(private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.loading = true;

    this.recipeService.list().subscribe(data => {
      this.recipes = data;
      this.loading = false;
    });
  }
}
