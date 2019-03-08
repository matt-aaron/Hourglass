import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Ride, RideType } from '@app/core';

@Component({
  selector: 'app-rides-table',
  templateUrl: './rides-table.component.html',
  styleUrls: ['./rides-table.component.css']
})
export class RidesTableComponent implements OnChanges {
  @Input() rideTypes: RideType[];

  private activeRideType: RideType;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.rideTypes && this.rideTypes !== null) {
      // Sort the rides by name
      this.rideTypes.forEach((rideType: RideType) => {
        rideType.rides.sort((a, b) => {
          if (a.name < b.name) {
            return -1;
          } else if (a.name > b.name) {
            return 1;
          } else {
            return 0;
          }
        });
      });
      this.activeRideType = this.rideTypes[0];
    }
  }

  isActiveRideType(type: RideType): boolean {
    return type === this.activeRideType;
  }

  getActiveRideType(): RideType {
    return this.activeRideType;
  }

  setActiveRideType(type: RideType): void {
    this.activeRideType = type;
  }

  getFormattedWaitTime(ride: Ride): string {
    if (!ride.status.open) {
      // The ride is closed
      return '<span class="text-muted">&#9679;</span> Closed';
    }

    // The ride is open, so we need to display the correct colored indicator next to the wait time in the table
    if (ride.status.waitTime <= 20) {
      return `<span class="text-success">&#9679;</span> ${ride.status.waitTime} minutes`;
    } else if (ride.status.waitTime <= 40) {
      return `<span class="text-warning">&#9679;</span> ${ride.status.waitTime} minutes`;
    } else {
      return `<span class="text-danger">&#9679;</span> ${ride.status.waitTime} minutes`;
    }
  }

}
