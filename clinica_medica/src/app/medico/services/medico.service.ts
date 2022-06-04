import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, take, tap } from 'rxjs';
import { Medico } from '../models/Medico';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private readonly API = '/medico';

  constructor(private httpClient: HttpClient) { }

  list(){
      return this.httpClient.get<Medico[]>(this.API).pipe(
        first(),
        delay(5000),
        tap(medicos => console.log(medicos))
      );
  }
}
