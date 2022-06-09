import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankgridviewComponent } from './bankgridview.component';

describe('BankgridviewComponent', () => {
  let component: BankgridviewComponent;
  let fixture: ComponentFixture<BankgridviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankgridviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BankgridviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
