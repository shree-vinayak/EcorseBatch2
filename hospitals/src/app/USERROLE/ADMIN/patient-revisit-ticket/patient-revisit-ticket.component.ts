import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patient-revisit-ticket',
  templateUrl: './patient-revisit-ticket.component.html',
  styleUrls: ['./patient-revisit-ticket.component.css']
})
export class PatientRevisitTicketComponent implements OnInit {

  title = 'XlsRead';
  file: any;
  arrayBuffer: any;
  filelist: any
  data: any = null;
  show: boolean = false;
  revisitdate:Date=null;
  regisdate:Date=null;

  constructor(private activatedroute: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {


    this.activatedroute.paramMap.subscribe(params => {
      this.data = JSON.parse(params.get('data'));
      this.show = true;
     this.revisitdate= new Date(Date.parse(this.data.revisitdate  ));
     this.regisdate= new Date(Date.parse(this.data.regisration_date));
    });

    setTimeout(() => {
      console.log('sleep');
      window.print();
    }, 3000);
  }

  newOpd() {
    this.router.navigate(['/admin-home'])
  }

}
