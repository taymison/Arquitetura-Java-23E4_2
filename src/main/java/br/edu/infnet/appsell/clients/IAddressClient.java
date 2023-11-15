package br.edu.infnet.appsell.clients;

import br.edu.infnet.appsell.model.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "adressClient")
public interface IAddressClient {
    @GetMapping(value = "/{cep}/json/")
    public Address searchCep(@PathVariable String cep);
}
