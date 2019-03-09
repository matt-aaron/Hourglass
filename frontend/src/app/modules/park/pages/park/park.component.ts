import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { forkJoin, Observable, Subscription } from 'rxjs';
import { Forecast, Operator, OperatorService, Park, RideType, RideTypeService, WeatherService } from '@app/core';

@Component({
  selector: 'app-park',
  templateUrl: './park.component.html',
  styleUrls: ['./park.component.css']
})
export class ParkComponent implements OnInit, OnDestroy {
  rideTypes$: Observable<RideType[]>;

  private routeSubscription: Subscription;
  private park: Park;
  private forecast: Forecast;
  private error: boolean;
  private loading: boolean;

  constructor(
    private operatorService: OperatorService,
    private rideTypeService: RideTypeService,
    private weatherService: WeatherService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Make sure the error card is hidden initially
    this.error = false;

    this.routeSubscription = this.route.params.subscribe(params => {
      // Set the park pointer to null
      this.park = null;

      // Display the loading indicator
      this.loading = true;

      // Fetch the operators from the API
      this.operatorService.getAll()
        .subscribe(response => {
          // Check if the ID has been specified in the route
          if (params.id) {
            // Loop through the operators and parks to locate the target park
            response.forEach((operator: Operator) => {
              operator.parks.forEach((park: Park) => {
                if (park.id === +params.id) {
                  // Matching park ID fount
                  // Set the park pointer to this park
                  this.park = park;

                  // Make sure the error card is hidden
                  this.error = false;
                }
              });
            });
          } else {
            // No park ID was specified, so we'll go ahead and route them to the first park in the API response
            console.log('park not found');
            this.router.navigate(['/park', response[0].parks[0].id]);
            this.park = response[0].parks[0];
          }

          // If the park ID wasn't found, let the user know there was an error
          if (this.park == null) {
            // Display the error card
            this.error = true;

            // Hide the loading indicator
            this.loading = false;

            // Exit the method
            return;
          }

          // Fetch the ride types for this park
          this.rideTypes$ = this.rideTypeService.getByPark(this.park.id);

          // Fetch the weather for this park
          const weather = this.weatherService.getByPark(this.park);

          forkJoin([this.rideTypes$, weather])
            .subscribe(responses => {
              this.forecast = responses[1];

              // Hide the loading indicator
              this.loading = false;
            });
        });
    });
  }

  ngOnDestroy(): void {
    this.routeSubscription.unsubscribe();
  }

  hasError(): boolean {
    return this.error;
  }

  isLoading(): boolean {
    return this.loading;
  }

  getFormattedTemperature(): string {
    return `${Math.round(this.forecast.currently.temperature)}&deg; F`;
  }

  getConditionsSummary(): string {
    return this.forecast.currently.summary;
  }

  getConditionsIcon(): string {
    const weatherIcons = {
      'clear-day': 'fe-sun',
      'clear-night': 'fe-moon',
      'rain': 'fe-cloud-rain',
      'snow': 'fe-cloud-snow',
      'sleet': 'fe-cloud-drizzle',
      'wind': 'fe-wind',
      'fog': 'fe-cloud',
      'cloudy': 'fe-cloud',
      'partly-cloudy-day': 'fe-cloud',
      'partly-cloudy-night': 'fe-cloud',
      'hail': 'fe-cloud-drizzle',
      'thunderstorm': 'fe-cloud-lighting',
      'tornado': 'fe-cloud-wind'
    };

    return weatherIcons[this.forecast.currently.icon];
  }
}
