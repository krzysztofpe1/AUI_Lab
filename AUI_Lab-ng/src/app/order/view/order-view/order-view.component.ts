import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../../model/order-details';
import { OrderService } from '../../service/order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/client/service/client.service';

@Component({
  selector: 'app-order-view',
  templateUrl: './order-view.component.html',
  styleUrls: ['./order-view.component.css'],
})
export class OrderViewComponent implements OnInit {
  order: OrderDetails | undefined;
  clientName: string = '';
  clientId: string = '';
  constructor(
    private service: OrderService,
    private clientSerivce: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service.getOrder(params['uuid']).subscribe((order) => {
        this.order = order;
        this.clientId = order.client.id;
        this.clientSerivce.getClient(this.clientId).subscribe((client) => {
          this.clientName = client.name;
        });
      });
    });
  }
}
