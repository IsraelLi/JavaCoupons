import { TestBed, inject } from '@angular/core/testing';

import { managerService } from './admin.service';

describe('managerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [managerService]
    });
  });

  it('should be created', inject([managerService], (service: managerService) => {
    expect(service).toBeTruthy();
  }));
});
