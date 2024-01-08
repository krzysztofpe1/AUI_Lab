import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../service/order.service';
import { Orders } from '../../model/orders';
import { Order } from '../../model/order';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  constructor(private service: OrderService) {}

  orders: Orders | undefined;

  ngOnInit(): void {
    this.service.getOrders().subscribe((orders) => {
      this.orders = orders;
    });
  }

  onDelete(order: Order): void {
    this.service.deleteOrder(order.id).subscribe(() => this.ngOnInit());
  }
}
