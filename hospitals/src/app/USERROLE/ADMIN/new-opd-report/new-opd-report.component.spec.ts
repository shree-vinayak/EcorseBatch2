import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOpdReportComponent } from './new-opd-report.component';

describe('NewOpdReportComponent', () => {
  let component: NewOpdReportComponent;
  let fixture: ComponentFixture<NewOpdReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewOpdReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewOpdReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
