import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Consultorio } from '../model/consultorio';

@Component({
  selector: 'app-consultorio',
  templateUrl: './consultorio.component.html',
  styleUrls: ['./consultorio.component.scss']
})
export class ConsultorioComponent implements OnInit {

  consultorios$: Observable<Consultorio[]> | undefined; 

  displayedColumns = ['numero_consultorio', 'data_hora'];

  constructor() { }

  ngOnInit(): void {
  }

}
