import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './order/view/order-list/order-list.component';
import { OrderViewComponent } from './order/view/order-view/order-view.component';
import { OrderEditComponent } from './order/view/order-edit/order-edit.component';
import { ClientListComponent } from './client/view/client-list/client-list.component';
import { ClientViewComponent } from './client/view/client-view/client-view.component';
import { ClientEditComponent } from './client/view/client-edit/client-edit.component';

const routes: Routes = [
  {
    component: OrderListComponent,
    path: 'orders',
  },
  {
    component: OrderViewComponent,
    path: 'orders/:uuid',
  },
  {
    component: OrderEditComponent,
    path: 'orders/:uuid/edit',
  },
  {
    component: ClientListComponent,
    path: 'clients',
  },
  {
    component: ClientViewComponent,
    path: 'clients/:uuid',
  },
  {
    component: ClientEditComponent,
    path: 'clients/:uuid/edit',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
