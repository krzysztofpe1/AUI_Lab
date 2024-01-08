import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clients } from '../model/Clients';
import { Client } from '../model/Client';
import { ClientForm } from '../model/ClientForm';
import { ClientDetails } from '../model/ClientDetails';
@Injectable({
  providedIn: 'root',
})
export class ClientService {
  constructor(private http: HttpClient) {}

  getClients(): Observable<Clients> {
    return this.http.get<Clients>('/api/clients');
  }
  getClient(uuid: string): Observable<ClientDetails> {
    return this.http.get<ClientDetails>(`/api/clients/${uuid}`);
  }
  deleteClient(uuid: string): Observable<any> {
    return this.http.delete<Client>(`/api/clients/${uuid}`);
  }
  putClient(uuid: string, request: ClientForm): Observable<any> {
    return this.http.put(`/api/clients/${uuid}`, request);
  }
  patchClient(uuid: string, request: ClientForm): Observable<any> {
    return this.http.patch(`/api/clients/${uuid}/update`, request);
  }
}
