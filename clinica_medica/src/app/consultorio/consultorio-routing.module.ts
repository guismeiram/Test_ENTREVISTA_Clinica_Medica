import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultorioFormComponent } from './consultorio-form/consultorio-form.component';
import { ConsultorioComponent } from './consultorio/consultorio.component';

const routes: Routes = [
  {path: 'consultorio', component: ConsultorioComponent},
  {path: 'new', component: ConsultorioFormComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ConsultorioRoutingModule { }
