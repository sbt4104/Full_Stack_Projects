import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GainersComponent } from './gainers.component';

describe('GainersComponent', () => {
  let component: GainersComponent;
  let fixture: ComponentFixture<GainersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GainersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GainersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
