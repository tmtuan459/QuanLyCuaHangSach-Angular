import { Book } from '../dto/book';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root',

})
export class BookService {





  constructor(
    private httpClient: HttpClient,
    ) { }
  getBookList(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl + 'book/listAllByDisable');
  }
  getBookListByIdAuthor(id:number): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl +`book/listBookByAuthor/${id}`);
  }
  getBookListByIdType(id:number): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl +`book/listBookByType/${id}`);
  }
  getBookInsufficient(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl + `book/listBookInsufficient`);
  }
  getBookRedundant(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl + `book/listBookRedundant`);
  }
  createBook(book: Book): Observable<Object> {
    return this.httpClient.post(environment.baseUrl + `book/create`, book);
  }
  updateBook( book: Book): Observable<Object> {
    return this.httpClient.put<Object>(environment.baseUrl + `book/edit`, book);
  }
  getBookById(id: number): Observable<Book> {
    return this.httpClient.get<Book>(environment.baseUrl + `book/findById/${id}`);
  }
  getBookByName(name: string): Observable<Book> {
    return this.httpClient.get<Book>(environment.baseUrl + `book/findByName/${name}`);
  }

  deleteBook(id: number): Observable<Object>{
    return this.httpClient.delete<Object>(environment.baseUrl + `book/delete/${id}`);
  }

}
