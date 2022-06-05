import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs/operators';
import { Medico } from '../models/Medico';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private readonly API = 'api/medico';

  constructor(private httpClient: HttpClient) { }

  list(){
      return this.httpClient.get<Medico[]>(this.API).pipe(
        first(),
        delay(5000),
        tap(medicos => console.log(medicos))
      );
  }

  save(record: Medico) {
    return this.httpClient.post<Medico>(this.API, record).pipe(first());
  }

}
