import { TestBed } from '@angular/core/testing';

import { ConsultorioService } from './consultorio.service';

describe('ConsultorioService', () => {
  let service: ConsultorioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultorioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
