import { TestBed } from '@angular/core/testing';

import { TypeService } from '../service/type.service';

describe('TypeService', () => {
  let service: TypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
