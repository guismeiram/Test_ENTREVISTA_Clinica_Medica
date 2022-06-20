import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppMaterialModule } from '../shred/app-material/app-material.module';
import { ShredModule } from '../shred/shred.module';
import { ConsultaRoutingModule } from './consulta-routing.module';
import { ConsultaComponent } from './consulta/consulta.component';


@NgModule({
  declarations: [
    ConsultaComponent
  ],
  imports: [
    CommonModule,
    ConsultaRoutingModule,
    AppMaterialModule,
    ShredModule
  ]
})
export class ConsultaModule { }
