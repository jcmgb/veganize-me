import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Recipe} from '../model/recipe';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment'

@Injectable()
export class RecipeService {

  //private appUrl: string = 'http://localhost:8080';
  //private appUrl: string = 'http://veganizeme3.us-east-1.elasticbeanstalk.com';
  private appUrl: string = environment.apiHostname;
  private recipesUrl: string;
  private veganizeUrl: string;


  constructor(private http: HttpClient) {
    this.recipesUrl = this.appUrl + '/recipes';
    this.veganizeUrl = this.appUrl + '/veganize';
  }

  public list(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipesUrl);
  }
}
