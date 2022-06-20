import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConsultorioRoutingModule } from './consultorio-routing.module';
import { ConsultorioComponent } from './consultorio/consultorio.component';
import { AppMaterialModule } from '../shred/app-material/app-material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ShredModule } from '../shred/shred.module';
import { ConsultorioFormComponent } from './consultorio-form/consultorio-form.component';


@NgModule({
  declarations: [
    ConsultorioComponent,
    ConsultorioFormComponent
  ],
  imports: [
    CommonModule,
    ConsultorioRoutingModule,
    AppMaterialModule,
    ShredModule,
    ReactiveFormsModule
  ]
})
export class ConsultorioModule { }
