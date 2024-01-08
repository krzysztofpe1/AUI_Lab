import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../model/orders';
import { OrderDetails } from '../model/order-details';
import { OrderForm } from '../model/order-form';
import { ClientDetails } from 'src/app/client/model/ClientDetails';
import { NewOrder } from '../model/order-new';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private http: HttpClient) {}

  getOrders(): Observable<Orders> {
    return this.http.get<Orders>('/api/orders');
  }

  getOrder(uuid: string): Observable<OrderDetails> {
    return this.http.get<OrderDetails>(`/api/orders/${uuid}`);
  }
  getClientOrders(uuid: string): Observable<ClientDetails> {
    return this.http.get<ClientDetails>(`/api/clients/${uuid}/orders`);
  }

  deleteOrder(uuid: string): Observable<any> {
    return this.http.delete(`/api/orders/${uuid}`);
  }

  patchOrder(uuid: string, request: OrderForm): Observable<any> {
    return this.http.patch(`/api/orders/${uuid}/update`, request);
  }
  putOrder(uuid: string, request: NewOrder): Observable<any> {
    return this.http.put(`/api/orders/${uuid}`, request);
  }
}
