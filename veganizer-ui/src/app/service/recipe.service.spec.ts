import { TestBed } from '@angular/core/testing';

import { RecipeService } from './recipe.service';
import {HttpClient, HttpHandler} from '@angular/common/http';

describe('RecipeService', () => {
  let service: RecipeService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        RecipeService,
        HttpClient,
        HttpHandler
      ]
    });
    service = TestBed.inject(RecipeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
