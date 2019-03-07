import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-statcard',
  templateUrl: './statcard.component.html',
  styleUrls: ['./statcard.component.css']
})
export class StatcardComponent implements OnInit {
  @Input() title: string;
  @Input() heading: string;
  @Input() icon: string;

  constructor() {
  }

  ngOnInit() {
  }
}
