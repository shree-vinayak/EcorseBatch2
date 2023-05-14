import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientRevisitReportComponent } from './patient-revisit-report.component';

describe('PatientRevisitReportComponent', () => {
  let component: PatientRevisitReportComponent;
  let fixture: ComponentFixture<PatientRevisitReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientRevisitReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientRevisitReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
