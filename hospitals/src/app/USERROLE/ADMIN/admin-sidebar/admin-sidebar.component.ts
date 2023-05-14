import { Component, OnInit } from '@angular/core';

declare var $: any;
@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // sidebar icon angle down animation
  animateIcon(id) {
    $('#' + id).toggleClass('activeMainBtn')
  }
}
