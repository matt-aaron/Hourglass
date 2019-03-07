import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { Operator, OperatorService } from '@app/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  operators$: Observable<Operator[]>;

  constructor(
    private operatorService: OperatorService
  ) { }

  ngOnInit(): void {
    this.loadOperators();
  }

  loadOperators() {
    this.operators$ = this.operatorService.getAll();
  }
}
