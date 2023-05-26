import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpDoctorOPSComponent } from './sp-doctor-ops.component';

describe('SpDoctorOPSComponent', () => {
  let component: SpDoctorOPSComponent;
  let fixture: ComponentFixture<SpDoctorOPSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpDoctorOPSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpDoctorOPSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
