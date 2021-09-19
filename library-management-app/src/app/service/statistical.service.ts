import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StatisticalService {

  constructor(private httpClient: HttpClient) { }
  listStatistical(): Observable<any>{
    return this.httpClient.get<any>(environment.baseUrl + `statistical/Revenue`);
  }
  listStatisticalByBook(): Observable<any>{
    return this.httpClient.get<any>(environment.baseUrl + `statistical/RevenueByBook`);
  }
  listtDetailsExport(): Observable<any>{
    return this.httpClient.get<any>(environment.baseUrl + `export/listDetails`);
  }
  listtDetailsImport(): Observable<any>{
    return this.httpClient.get<any>(environment.baseUrl + `import/listDetails`);
  }

}
