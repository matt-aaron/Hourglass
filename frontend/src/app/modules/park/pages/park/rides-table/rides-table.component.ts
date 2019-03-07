import { Component, OnInit, Input } from '@angular/core';

import { RideType } from '@app/core';

@Component({
  selector: 'app-rides-table',
  templateUrl: './rides-table.component.html',
  styleUrls: ['./rides-table.component.css']
})
export class RidesTableComponent implements OnInit {
  @Input() rideTypes: RideType[];
  constructor() { }

  ngOnInit() { }
}
