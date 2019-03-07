import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RidesTableComponent } from './rides-table.component';

describe('RidesTableComponent', () => {
  let component: RidesTableComponent;
  let fixture: ComponentFixture<RidesTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RidesTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RidesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
