import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultorioComponent } from './consultorio.component';

describe('ConsultorioComponent', () => {
  let component: ConsultorioComponent;
  let fixture: ComponentFixture<ConsultorioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultorioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultorioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
