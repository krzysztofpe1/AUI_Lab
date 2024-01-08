import { Client } from 'src/app/client/model/Client';

export interface OrderDetails {
  id: string;
  name: string;
  description: string;
  orderDate: string;
  deliveryDate: string;
  client: Client;
}
