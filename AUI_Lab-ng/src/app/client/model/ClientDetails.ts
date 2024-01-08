import { Order } from 'src/app/order/model/order';

export interface ClientDetails {
  id: string;
  name: string;
  surname: string;
  clientAddress: string;
  orders: Order[];
}
