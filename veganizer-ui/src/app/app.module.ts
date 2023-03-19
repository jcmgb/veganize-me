import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import {RecipeService} from './service/recipe-service.service';
import { HttpClientModule } from '@angular/common/http';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    RecipeListComponent,
    RecipeFormComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [
    RecipeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
