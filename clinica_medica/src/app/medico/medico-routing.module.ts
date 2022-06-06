import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MedicoFormComponent } from './medico-form/medico-form.component';
import { MedicoComponent } from './medico/medico.component';

const routes: Routes = [
  { path: '', component: MedicoComponent },
  { path: 'new', component: MedicoFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicoRoutingModule { }
