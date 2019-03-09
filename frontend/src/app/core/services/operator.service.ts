import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService, Operator } from '@app/core';

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
