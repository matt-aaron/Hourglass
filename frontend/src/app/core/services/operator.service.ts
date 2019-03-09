import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService } from '@app/core/services/api.service';
import { Operator } from '@app/core/models/operator.model';

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
