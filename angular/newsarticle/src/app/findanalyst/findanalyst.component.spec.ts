import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindanalystComponent } from './findanalyst.component';

describe('FindanalystComponent', () => {
  let component: FindanalystComponent;
  let fixture: ComponentFixture<FindanalystComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindanalystComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindanalystComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
