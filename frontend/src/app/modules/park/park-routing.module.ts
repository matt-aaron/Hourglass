import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParkComponent } from '@app/modules/park/pages/park/park.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: ':id',
        component: ParkComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ParkRoutingModule {
}
