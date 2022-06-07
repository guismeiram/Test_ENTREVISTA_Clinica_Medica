import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {   path: '', pathMatch: 'full', redirectTo: 'medico'},
  {   path: '', pathMatch: 'full', redirectTo: 'consultorio'},
  { 
    path: 'medico',
    loadChildren: () => import('./medico/medico.module').then(m => m.MedicoModule)
  },
  { 
    path: 'consultorio',
    loadChildren: () => import('./consultorio/consultorio.module').then(m => m.ConsultorioModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
