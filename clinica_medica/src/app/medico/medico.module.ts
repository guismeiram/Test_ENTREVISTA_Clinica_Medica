import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MedicoRoutingModule } from './medico-routing.module';
import { MedicoComponent } from './medico/medico.component';
import { AppMaterialModule } from '../shred/app-material/app-material.module';
import { ShredModule } from '../shred/shred.module';
import { MedicoFormComponent } from './medico-form/medico-form.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    MedicoComponent,
    MedicoFormComponent
  ],
  imports: [
    CommonModule,
    MedicoRoutingModule,
    AppMaterialModule,
    ShredModule,
    ReactiveFormsModule
  ]
})
export class MedicoModule { }
