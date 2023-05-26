import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevisitReportComponent } from './revisit-report.component';

describe('RevisitReportComponent', () => {
  let component: RevisitReportComponent;
  let fixture: ComponentFixture<RevisitReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevisitReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevisitReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
