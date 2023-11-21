package br.edu.infnet.appsell.clients;

import br.edu.infnet.appsell.model.domain.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/info", name = "infoClient")
public interface IInfoClient {

    @GetMapping(value = "/list")
    public List<Info> getList();

    @GetMapping(value = "/insert")
    public Info insert(Info info);
}
