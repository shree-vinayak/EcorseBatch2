import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientRevisitTicketComponent } from './patient-revisit-ticket.component';

describe('PatientRevisitTicketComponent', () => {
  let component: PatientRevisitTicketComponent;
  let fixture: ComponentFixture<PatientRevisitTicketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientRevisitTicketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientRevisitTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
