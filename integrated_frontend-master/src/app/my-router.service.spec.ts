import { TestBed } from '@angular/core/testing';

import { MyRouterService } from './my-router.service';

describe('MyRouterService', () => {
  let service: MyRouterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyRouterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
