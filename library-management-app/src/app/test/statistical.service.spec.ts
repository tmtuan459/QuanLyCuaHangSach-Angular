import { TestBed } from '@angular/core/testing';

import { StatisticalService } from '../service/statistical.service';

describe('StatisticalService', () => {
  let service: StatisticalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatisticalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
