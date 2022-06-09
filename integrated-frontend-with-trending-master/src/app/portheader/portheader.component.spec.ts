import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PortheaderComponent } from './portheader.component';

describe('PortheaderComponent', () => {
  let component: PortheaderComponent;
  let fixture: ComponentFixture<PortheaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PortheaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PortheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
