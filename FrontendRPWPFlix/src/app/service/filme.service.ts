import { Injectable, model } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Filme } from '../model/filme';
@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  private url = "http://localhost:8080/cfilme/filme";

  constructor(private httpClient: HttpClient) { }

  // Método para listar todos os filmes
  listarFilmes(): Observable<Filme[]> {
    return this.httpClient.get<Filme[]>(`${this.url}`);
  }

  // Método para consultar um filme pelo ID
  consultarFilme(id: number): Observable<Filme> {
    return this.httpClient.get<Filme>(`${this.url}/${id}`);
  }

  // Método para excluir um filme pelo ID
  excluirFilme(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.url}/${id}`);
  }

  // Método para inserir um novo filme
  inserirFilme(filme: Filme): Observable<object> {
    return this.httpClient.post(`${this.url}`, filme);
  }

  // Método para alterar um filme existente pelo ID
  alterarFilme(id: number, filme: Filme): Observable<object> {
    return this.httpClient.put(`${this.url}/${id}`, filme);
  }
}
