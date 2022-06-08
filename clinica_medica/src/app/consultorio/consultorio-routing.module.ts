import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultorioComponent } from './consultorio/consultorio.component';

const routes: Routes = [
  {path: 'consultorio', component: ConsultorioComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ConsultorioRoutingModule { }
