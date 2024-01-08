import { Component, OnInit } from '@angular/core';
import { ClientDetails } from '../../model/ClientDetails';
import { ClientService } from '../../service/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from 'src/app/order/service/order.service';
import { NewOrder } from 'src/app/order/model/order-new';

@Component({
  selector: 'app-client-view',
  templateUrl: './client-view.component.html',
  styleUrls: ['./client-view.component.css'],
})
export class ClientViewComponent implements OnInit {
  clientOrders: ClientDetails | any;
  client: ClientDetails | any;
  clientId: string = '';
  newOrderId: string = '';
  newOrder: NewOrder = {
    name: '',
    description: '',
    order_date: '',
    delivery_date: '',
    client: '',
  };
  constructor(
    private clientService: ClientService,
    private orderService: OrderService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.orderService
        .getClientOrders(params['uuid'])
        .subscribe((clientOrders) => {
          this.clientOrders = clientOrders;
          this.clientId = params['uuid'];
        });
      this.clientService.getClient(params['uuid']).subscribe((client) => {
        this.client = client;
      });
    });
  }
  onSubmit(): void {
    this.newOrder.client = this.clientId;

    this.orderService
      .putOrder(this.newOrderId, this.newOrder)
      .subscribe(() => this.router.navigate(['/orders']));
  }
}
