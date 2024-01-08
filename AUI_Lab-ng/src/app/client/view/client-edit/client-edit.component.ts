import { Component } from '@angular/core';
import { ClientService } from '../../service/client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientForm } from '../../model/ClientForm';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css'],
})
export class ClientEditComponent {
  uuid: string | undefined;

  client: ClientForm | undefined;

  original: ClientForm | undefined;
  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.clientService.getClient(params['uuid']).subscribe((client) => {
        this.uuid = client.id;
        this.client = {
          id: client.id,
          name: client.name,
          surname: client.surname,
          clientAddress: client.clientAddress,
        };
        this.original = { ...this.client };
      });
    });
  }
  onSubmit(): void {
    this.clientService
      .patchClient(this.uuid!, this.client!)
      .subscribe(() => this.router.navigate(['/clients']));
  }
}
