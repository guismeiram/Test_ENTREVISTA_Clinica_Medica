import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Consulta } from '../model/consulta';
import { delay, first, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConsultaService {

  private readonly API = 'api/medico';

  constructor(private httpClient: HttpClient) { }

  list(){
      return this.httpClient.get<Consulta[]>(this.API).pipe(
        first(),
        //delay(5000),
        tap((consulta: any) => console.log(consulta))
      );
  }

  save(record: Consulta) {
    return this.httpClient.post<Consulta>(this.API, record).pipe(first());
  }
}
