import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sp-home',
  templateUrl: './sp-home.component.html',
  styleUrls: ['./sp-home.component.css']
})
export class SpHomeComponent implements OnInit {
  loader: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

}
