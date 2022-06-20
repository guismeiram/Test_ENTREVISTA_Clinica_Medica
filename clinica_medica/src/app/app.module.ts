import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { ConsultorioModule } from './consultorio/consultorio.module';
import { MedicoModule } from './medico/medico.module';
import { ConsultaModule } from './consulta/consulta.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    HttpClientModule,
    ConsultorioModule,
    MedicoModule,
    ConsultaModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
