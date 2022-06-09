import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WatchlisttradeComponent } from './watchlisttrade.component';

describe('WatchlisttradeComponent', () => {
  let component: WatchlisttradeComponent;
  let fixture: ComponentFixture<WatchlisttradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WatchlisttradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WatchlisttradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
