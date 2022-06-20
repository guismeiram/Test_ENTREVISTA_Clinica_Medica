import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultorioFormComponent } from './consultorio-form.component';

describe('ConsultorioFormComponent', () => {
  let component: ConsultorioFormComponent;
  let fixture: ComponentFixture<ConsultorioFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultorioFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultorioFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
