import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankupdateComponent } from './bankupdate.component';

describe('BankupdateComponent', () => {
  let component: BankupdateComponent;
  let fixture: ComponentFixture<BankupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankupdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BankupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
