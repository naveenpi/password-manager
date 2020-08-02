import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Manager } from './manager';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {
  
  

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCredentials(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/keys/${id}`);
  }

  getList(): Observable<any> {
    console.log(this.http.get(`${this.baseUrl}/keys`))
    return this.http.get(`${this.baseUrl}/keys`);
  }

  createCredentials(manager: Manager): Observable<Object> {
    
    console.log(manager);
    return this.http.post(`${this.baseUrl}/create`, manager);
  }
  
  deleteCredentials(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/keys/${id}`, { responseType: 'text' });
  }

  updateCredentials(id: number, manager: Manager) {
    console.log("id: "+id);
    return this.http.put(`${this.baseUrl}/update/${id}`, manager);
  }


}