import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ParkRoutingModule } from './park-routing.module';
import { ParkComponent } from './pages/park/park.component';
import { StatcardComponent } from './pages/park/statcard/statcard.component';
import { RidesTableComponent } from './pages/park/rides-table/rides-table.component';
import { HeaderComponent } from './pages/park/header/header.component';

@NgModule({
  declarations: [ParkComponent, StatcardComponent, RidesTableComponent, HeaderComponent],
  imports: [
    CommonModule,
    ParkRoutingModule
  ]
})
export class ParkModule { }
