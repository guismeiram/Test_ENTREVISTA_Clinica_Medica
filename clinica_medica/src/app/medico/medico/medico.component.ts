import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shred/components/error-dialog/error-dialog.component';
import { Medico } from '../models/Medico';
import { MedicoService } from '../services/medico.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent implements OnInit {

  medicos$: Observable<Medico[]>; 

  displayedColumns = ['crm','nome','idade'];

  //medicoService:MedicoService;

  constructor(private medicoService:MedicoService, public dialog: MatDialog) { 
    //this.medicos = [];
   // this.medicoService = new MedicoService();
   this.medicos$ = this.medicoService.list().pipe(
     catchError(error => {
       this.onError('Erro ao carregar medicos.');
       return of([])
      })
     );
   

  }

  onError(errorMsg: string){
    this.dialog.open(ErrorDialogComponent, {
        data:{
          animal: 'panda'
        }
    })
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

}
function DialogDataExampleDialog(DialogDataExampleDialog: any, arg1: { data: { animal: string; }; }) {
  throw new Error('Function not implemented.');
}

