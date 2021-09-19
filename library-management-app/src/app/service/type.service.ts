import { Observable } from 'rxjs';
import { Type } from '../dto/type';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private httpClient: HttpClient,) { }
  getTypeList(): Observable<Type[]> {
    return this.httpClient.get<Type[]>(environment.baseUrl + `type/listAllByDisable`);
  }
  createType(type: Type): Observable<Object> {
    return this.httpClient.post(environment.baseUrl + `type/create`, type);
  }
  updateType( type: Type): Observable<Object> {
    return this.httpClient.put<Object>(environment.baseUrl + `type/edit`, type);
  }
  getTypeById(id: number): Observable<Type> {
    return this.httpClient.get<Type>(environment.baseUrl + `type/findById/${id}`);
  }

  deleteType(id: number): Observable<Object>{
    return this.httpClient.delete<Object>(environment.baseUrl + `type/delete/${id}`);
  }


}
