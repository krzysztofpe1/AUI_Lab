import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../service/client.service';
import { Clients } from '../../model/Clients';
import { Client } from '../../model/Client';
import { ClientForm } from '../../model/ClientForm';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css'],
})
export class ClientListComponent implements OnInit {
  constructor(
    private service: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  clients: Clients | undefined;
  newClient: ClientForm = { id: '', name: '', surname: '', clientAddress: '' };

  ngOnInit(): void {
    this.service.getClients().subscribe((clients) => {
      this.clients = clients;
      console.log(clients);
    });
  }
  onDelete(client: Client): void {
    this.service.deleteClient(client.id).subscribe(() => this.ngOnInit());
  }
  onSubmit(): void {
    this.service
      .putClient(this.newClient.id, this.newClient)
      .subscribe(() => this.router.navigate(['/clients']));
  }
}
