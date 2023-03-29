import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeFormComponent } from './recipe-form.component';
import {RouterTestingModule} from '@angular/router/testing';
import {AppComponent} from '../app.component';
import {RecipeService} from '../service/recipe-service.service';
import {HttpClient, HttpHandler} from '@angular/common/http';

describe('RecipeFormComponent', () => {

  let component: RecipeFormComponent;
  let fixture: ComponentFixture<RecipeFormComponent>;

  beforeEach(async () => {
      await TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          AppComponent
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
