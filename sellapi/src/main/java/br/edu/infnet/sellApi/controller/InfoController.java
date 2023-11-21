package br.edu.infnet.sellApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sellApi.model.domain.Info;
import br.edu.infnet.sellApi.model.service.InfoService;

@RestController
@RequestMapping("/api/info")
public class InfoController {
	
	@Autowired
	private InfoService infoService;

	@GetMapping(value = "/list")
	public List<Info> obterLista(){
		return infoService.obterLista();
	}
	
	@PostMapping(value = "/insert")
	public Info incluir(@RequestBody Info info) {
		return infoService.incluir(info);
	}
}