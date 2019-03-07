import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Observable, Subscription } from 'rxjs';
import { Operator, OperatorService, Park, RideType, RideTypeService } from '@app/core';

@Component({
  selector: 'app-park',
  templateUrl: './park.component.html',
  styleUrls: ['./park.component.css']
})
export class ParkComponent implements OnInit, OnDestroy {
  rideTypes$: Observable<RideType[]>;

  private routeSubscription: Subscription;
  private park: Park;

  constructor(
    private operatorService: OperatorService,
    private rideTypeService: RideTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.routeSubscription = this.route.params.subscribe(params => {
      this.operatorService.getAll()
        .subscribe(response => {
          response.forEach((operator: Operator) => {
            operator.parks.forEach((park: Park) => {
              if (park.id === +params.id) {
                this.park = park;
              }
            });
          });


          if (typeof this.park === undefined) {
            this.router.navigate(['/park', response[0].parks[0].id]);
          }

          this.rideTypes$ = this.rideTypeService.getByPark(this.park.id);
        });
    });
  }

  ngOnDestroy(): void {
    this.routeSubscription.unsubscribe();
  }
}
