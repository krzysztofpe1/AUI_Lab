package org.AUI_Lab.client.initialize;

import org.AUI_Lab.client.entity.Client;
import org.AUI_Lab.client.service.ClientService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class InitializeData implements InitializingBean {
    private final ClientService clientService;
    @Autowired
    public InitializeData(ClientService clientService){
        this.clientService = clientService;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        if(clientService.findAll().isEmpty()){
            Client marcinStenka = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1")).name("Marcin").surname("Stenka").clientAddress("Turzycowa 33").build();
            Client kubaStachowicz = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2")).name("Kuba").surname("Stachowicz").clientAddress("Okopowa 12").build();
            Client oskarWilda = Client.builder().id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3")).name("Oskar").surname("Wilda").clientAddress("Wiejska 3").build();

            clientService.addClient(marcinStenka);
            clientService.addClient(kubaStachowicz);
            clientService.addClient(oskarWilda);
        }
    }
}
