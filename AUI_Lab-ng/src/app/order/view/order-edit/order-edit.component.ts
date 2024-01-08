import { Component, OnInit } from '@angular/core';
import { Orders } from '../../model/orders';
import { OrderService } from '../../service/order.service';
import { Order } from '../../model/order';
import { OrderForm } from '../../model/order-form';
import { Clients } from 'src/app/client/model/Clients';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/client/service/client.service';

@Component({
  selector: 'app-order-edit',
  templateUrl: './order-edit.component.html',
  styleUrls: ['./order-edit.component.css'],
})
export class OrderEditComponent implements OnInit {
  uuid: string | undefined;

  order: OrderForm | undefined;

  original: OrderForm | undefined;

  clients: Clients | undefined;

  constructor(
    private orderService: OrderService,
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.clientService.getClients().subscribe((clients) => (this.clients = clients));
      this.orderService.getOrder(params['uuid']).subscribe((order) => {
        this.uuid = order.id;
        this.order = {
          name: order.name,
          description: order.description,
          orderDate: order.orderDate,
          deliveryDate: order.deliveryDate,
          client: order.client
        };
        this.original = { ...this.order };
      });
    });
  }

  onSubmit(): void {
    this.orderService
      .patchOrder(this.uuid!, this.order!)
      .subscribe(() => this.router.navigate(['/orders']));
  }
}
