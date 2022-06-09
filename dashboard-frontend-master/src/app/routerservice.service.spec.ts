import { TestBed } from '@angular/core/testing';

import { RouterserviceService } from './routerservice.service';

describe('RouterserviceService', () => {
  let service: RouterserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouterserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
