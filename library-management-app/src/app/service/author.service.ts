
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Author } from '../dto/author';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private httpClient: HttpClient,) { }
  getAuthorList(): Observable<Author[]> {
    return this.httpClient.get<Author[]>(environment.baseUrl +`author/listAllByDisable`);
  }
  createAuthor(author: Author): Observable<Object> {
    return this.httpClient.post(environment.baseUrl +`author/create`, author);
  }
  updateAuthor( author: Author): Observable<Object> {
    return this.httpClient.put<Object>(environment.baseUrl +`author/edit`, author);
  }
  getAuthorById(id: number): Observable<Author> {
    return this.httpClient.get<Author>(environment.baseUrl +`author/findById/${id}`);
  }

  deleteAuthor(id: number): Observable<Object>{
    return this.httpClient.delete<Object>(environment.baseUrl +`author/delete/${id}`);
  }
}
