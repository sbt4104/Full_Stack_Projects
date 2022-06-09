import { TestBed } from '@angular/core/testing';

import { SqlauthService } from './sqlauth.service';

describe('SqlauthService', () => {
  let service: SqlauthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SqlauthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
