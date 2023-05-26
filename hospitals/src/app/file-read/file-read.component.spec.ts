import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FileReadComponent } from './file-read.component';

describe('FileReadComponent', () => {
  let component: FileReadComponent;
  let fixture: ComponentFixture<FileReadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FileReadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FileReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
