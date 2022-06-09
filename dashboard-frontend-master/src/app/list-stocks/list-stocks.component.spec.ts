import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListStocksComponent } from './list-stocks.component';

describe('ListStocksComponent', () => {
  let component: ListStocksComponent;
  let fixture: ComponentFixture<ListStocksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListStocksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListStocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
