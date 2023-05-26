import { Component, OnInit } from '@angular/core';
declare var $: any;
@Component({
  selector: 'app-sp-sidebar',
  templateUrl: './sp-sidebar.component.html',
  styleUrls: ['./sp-sidebar.component.css']
})
export class SpSidebarComponent implements OnInit {

  constructor() { }
  ngOnInit() {

  }
  // sidebar icon angle down animation
  animateIcon(id) {
    $('#' + id).toggleClass('activeMainBtn')
  }

}
