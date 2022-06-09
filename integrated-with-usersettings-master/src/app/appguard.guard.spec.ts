import { TestBed } from '@angular/core/testing';

import { AppguardGuard } from './appguard.guard';

describe('AppguardGuard', () => {
  let guard: AppguardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AppguardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
