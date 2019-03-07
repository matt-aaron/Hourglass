import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Operator } from '../models/operator.model';

const routes = {
  operators: '/operators'
};

@Injectable({
  providedIn: 'root'
})
export class OperatorService {
  constructor(private apiService: ApiService) { }

  getAll(): Observable<Operator[]> {
    return this.apiService.get(routes.operators);
  }
}
