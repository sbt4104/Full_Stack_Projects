import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessloginComponent } from './successlogin.component';

describe('SuccessloginComponent', () => {
  let component: SuccessloginComponent;
  let fixture: ComponentFixture<SuccessloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuccessloginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
