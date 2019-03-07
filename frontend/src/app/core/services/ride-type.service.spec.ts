import { TestBed } from '@angular/core/testing';

import { RideTypeService } from './ride-type.service';

describe('RideTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RideTypeService = TestBed.get(RideTypeService);
    expect(service).toBeTruthy();
  });
});
