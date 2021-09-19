import { HttpClient } from '@angular/common/http';
import { Export } from './../dto/export';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExportService {

  constructor(private httpClient: HttpClient,) {}
  ListExport(exp: Export[]){
    return this.httpClient.post(environment.baseUrl + `export/create`,exp);
  }
}
