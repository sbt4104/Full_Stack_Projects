import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WatchlistcardviewComponent } from './watchlistcardview.component';

describe('WatchlistcardviewComponent', () => {
  let component: WatchlistcardviewComponent;
  let fixture: ComponentFixture<WatchlistcardviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WatchlistcardviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WatchlistcardviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
