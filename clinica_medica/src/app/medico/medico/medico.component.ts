import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
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

  displayedColumns = ['crm','especialidade','nome','idade'];

  dataSource!:MatTableDataSource<any>;

  @ViewChild('paginator') paginator! : MatPaginator; 
  @ViewChild(MatSort) matSort! : MatSort;

  //medicoService:MedicoService;

  constructor(private medicoService:MedicoService,  
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute) { 

   this.medicos$ = this.medicoService.list()
   .pipe(
     catchError(error => {
       this.onError('Erro ao carregar medicos.');
       this.dataSource = new MatTableDataSource(this.displayedColumns);
       this.dataSource.paginator = this.paginator;
       this.dataSource.sort = this.matSort;
       return of([])
      })
     );
   

  }

   filterData($event : any){
    this.dataSource.filter = $event.target.value;
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


