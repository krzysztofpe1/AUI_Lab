import { Client } from 'src/app/client/model/Client';

export interface OrderForm {
  name: string;
  description: string;
  orderDate: string;
  deliveryDate: string;
  client: Client;
}
