import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Import } from '../dto/import';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImportService {

  constructor(private httpClient: HttpClient,) { }


  ListImport(imp: Import[]){
    return this.httpClient.post(environment.baseUrl + `import/create`,imp);
  }

}
