import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavComponent } from './components/nav/nav.component';
import { MainComponent } from './components/main/main.component';
import { OrderViewComponent } from './order/view/order-view/order-view.component';
import { OrderListComponent } from './order/view/order-list/order-list.component';
import { OrderEditComponent } from './order/view/order-edit/order-edit.component';
import { OrderService } from './order/service/order.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ClientListComponent } from './client/view/client-list/client-list.component';
import { ClientViewComponent } from './client/view/client-view/client-view.component';
import { ClientEditComponent } from './client/view/client-edit/client-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
    MainComponent,
    OrderViewComponent,
    OrderListComponent,
    OrderEditComponent,
    ClientListComponent,
    ClientViewComponent,
    ClientEditComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [OrderService],
  bootstrap: [AppComponent],
})
export class AppModule {}
