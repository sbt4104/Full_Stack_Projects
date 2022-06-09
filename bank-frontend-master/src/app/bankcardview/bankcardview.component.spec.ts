import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankcardviewComponent } from './bankcardview.component';

describe('BankcardviewComponent', () => {
  let component: BankcardviewComponent;
  let fixture: ComponentFixture<BankcardviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankcardviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BankcardviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
