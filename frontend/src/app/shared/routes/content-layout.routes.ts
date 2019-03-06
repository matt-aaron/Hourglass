import { Routes } from '@angular/router';

export const CONTENT_ROUTES: Routes = [
  {
    path: 'park',
    loadChildren: './modules/dashboard/dashboard.module#DashboardModule'
  }
]
