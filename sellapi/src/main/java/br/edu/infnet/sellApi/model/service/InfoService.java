package br.edu.infnet.sellApi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sellApi.model.domain.Info;
import br.edu.infnet.sellApi.model.repository.InfoRepository;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;

	public List<Info> obterLista() {
		return (List<Info>) infoRepository.findAll();
	}

	public Info incluir(Info info) {
		return infoRepository.save(info);
	}

}