import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MedicoRoutingModule } from './medico-routing.module';
import { MedicoComponent } from './medico/medico.component';
import { AppMaterialModule } from '../shred/app-material/app-material.module';



@NgModule({
  declarations: [
    MedicoComponent
  ],
  imports: [
    CommonModule,
    MedicoRoutingModule,
    AppMaterialModule
  
  ]
})
export class MedicoModule { }
