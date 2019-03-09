import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService } from '@app/core/services/api.service';
import { Hours, Park } from '@app/core/models';

const routes = {
  hours: (id: number) => `/park/${id}/hours`
};

@Injectable({
  providedIn: 'root'
})
export class HoursService {
  constructor(private apiService: ApiService) { }

  getByPark(park: Park): Observable<Hours> {
    return this.apiService.get(routes.hours(park.id));
  }
}
