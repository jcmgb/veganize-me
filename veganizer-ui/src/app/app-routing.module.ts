import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RecipeListComponent} from './recipe-list/recipe-list.component';
import {RecipeFormComponent} from './recipe-form/recipe-form.component';

const routes: Routes = [
  {path: 'recipes', component: RecipeListComponent},
  {path: 'veganize', component: RecipeFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
