import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';
import { Consultorio } from '../model/consultorio';

@Injectable({
  providedIn: 'root'
})
export class ConsultorioService {

  private readonly API = 'api/consultorio';

  constructor(private httpClient: HttpClient) { }

  list(){
      return this.httpClient.get<Consultorio[]>(this.API).pipe(
        first(),
        //delay(5000),
        tap(consultorios => console.log(consultorios))
      );
  }

  save(record: Consultorio) {
    return this.httpClient.post<Consultorio>(this.API, record).pipe(first());
  }
}
