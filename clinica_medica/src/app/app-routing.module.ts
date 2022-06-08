import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ConsultorioComponent } from './consultorio/consultorio/consultorio.component';
import { MedicoComponent } from './medico/medico/medico.component';

const routes: Routes = [
  { path: 'medico', redirectTo: 'medico', pathMatch: 'full'},
  { path: 'consultorio', redirectTo: 'consultorio', pathMatch: 'full'}
];
//  { path: '', pathMatch: 'full', redirectTo: 'courses' },

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
