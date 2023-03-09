import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RecipeListComponent} from './recipe-list/recipe-list.component';

const routes: Routes = [
  {path: 'recipes', component: RecipeListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
