import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorWiseReportComponent } from './doctor-wise-report.component';

describe('DoctorWiseReportComponent', () => {
  let component: DoctorWiseReportComponent;
  let fixture: ComponentFixture<DoctorWiseReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorWiseReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorWiseReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
