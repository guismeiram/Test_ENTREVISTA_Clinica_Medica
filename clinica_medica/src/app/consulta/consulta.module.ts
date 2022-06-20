import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppMaterialModule } from '../shred/app-material/app-material.module';
import { ShredModule } from '../shred/shred.module';
import { ConsultaRoutingModule } from './consulta-routing.module';
import { ConsultaComponent } from './consulta/consulta.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ConsultaComponent
  ],
  imports: [
    CommonModule,
    ConsultaRoutingModule,
    AppMaterialModule,
    ShredModule,
    ReactiveFormsModule
  ]
})
export class ConsultaModule { }
