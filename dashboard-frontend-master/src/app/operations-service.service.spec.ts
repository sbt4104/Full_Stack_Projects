import { TestBed } from '@angular/core/testing';

import { OperationsServiceService } from './operations-service.service';

describe('OperationsServiceService', () => {
  let service: OperationsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperationsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
