import { HttpClient } from '@angular/common/http';
import { AfterContentInit, AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import * as XLSX from 'xlsx'; 

@Component({
  selector: 'app-file-read',
  templateUrl: './file-read.component.html',
  styleUrls: ['./file-read.component.css']
})
export class FileReadComponent implements OnInit {
title ='XlsRead';
file:any; 
arrayBuffer:any;
filelist:any
data:any=null;
show:boolean=false;

regisdate:Date=null;
 
constructor(private activatedroute:ActivatedRoute,private router:Router)
{

}

  ngOnInit(): void {
    this.activatedroute.paramMap.subscribe(params => { 
      this.data = JSON.parse(params.get('data'));
      this.show=true; 
      this.regisdate= new Date(Date.parse(this.data.regisration_date));
  });

  setTimeout(() => {
    console.log('sleep');
    window.print();
  },3000 );
  }

  newOpd()
  {
     this.router.navigate(['/admin-home'])
  }

}
