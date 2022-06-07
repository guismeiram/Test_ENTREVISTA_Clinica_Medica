import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shred/components/error-dialog/error-dialog.component';
import { Consultorio } from '../model/consultorio';
import { ConsultorioService } from '../services/consultorio.service';

@Component({
  selector: 'app-consultorio',
  templateUrl: './consultorio.component.html',
  styleUrls: ['./consultorio.component.scss']
})
export class ConsultorioComponent implements OnInit {

  consultorios$: Observable<Consultorio[]> | undefined; 

  displayedColumns = ['numero_consultorio', 'data_hora'];

  constructor(private consultorioService:ConsultorioService,  
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute) { 

   this.consultorios$ = this.consultorioService.list()
   .pipe(
    catchError(error => {
      this.onError('Erro ao carregar cursos.');
      return of([])
    })
  );
   

  }

  
  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
   

  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo: this.route});
  }
}
