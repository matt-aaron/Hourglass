import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { ApiService, Forecast, Park } from '@app/core';

const routes = {
  forecast: (latitude: number, longitude: number) => `/weather/${latitude},${longitude}?exclude=minutely,hourly,daily,alerts,flags`
};

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  constructor(private apiService: ApiService) { }

  getByPark(park: Park): Observable<Forecast> {
    return this.apiService.get(routes.forecast(park.location.latitude, park.location.longitude));
  }
}
