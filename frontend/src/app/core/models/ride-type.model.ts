import { Ride } from './ride.model';

export class RideType {
  id: number;
  platformId: string;
  name: string;
  rides: Ride[];
}
