import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {   path: '', pathMatch: 'full', redirectTo: 'medico'},
  { 
    path: 'medico',
    loadChildren: () => import('./medico/medico.module').then(m => m.MedicoModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
