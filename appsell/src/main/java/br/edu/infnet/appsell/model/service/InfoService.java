package br.edu.infnet.appsell.model.service;

import br.edu.infnet.appsell.clients.IInfoClient;
import br.edu.infnet.appsell.model.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private IInfoClient infoClient;

    public List<Info> getList() {
        return infoClient.getList();
    }

    public Info insert(Info info) {
        return infoClient.insert(info);
    }
}
