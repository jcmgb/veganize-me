import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeFormComponent } from './recipe-form.component';
import {RouterTestingModule} from '@angular/router/testing';
import {RecipeService} from '../service/recipe.service';
import {HttpClient, HttpHandler} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ClipboardModule} from "@angular/cdk/clipboard";

describe('RecipeFormComponent', () => {

  let component: RecipeFormComponent;
  let fixture: ComponentFixture<RecipeFormComponent>;

  beforeEach(async () => {
      await TestBed.configureTestingModule({
        imports: [
          RouterTestingModule,
          FormsModule,
          ReactiveFormsModule,
          ClipboardModule
        ],
        declarations: [
          RecipeFormComponent
        ],
        providers: [
          RecipeService,
          HttpClient,
          HttpHandler
        ]
      }).compileComponents();

    fixture = TestBed.createComponent(RecipeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
