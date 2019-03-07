import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { RideType } from '../models/ride-type.model';

const routes = {
  rideTypes: (id: number) => `/park/${id}/rides`
};

@Injectable({
  providedIn: 'root'
})
export class RideTypeService {
  constructor(private apiService: ApiService) { }

  getByPark(id: number): Observable<RideType[]> {
    return this.apiService.get(routes.rideTypes(id));
  }
}
