package com.ivra.graphql.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivra.graphql.graphql.service.LeerArchivoService;

@Controller
public class LeerArchivoResolverImpl {
	
	@Autowired
	private LeerArchivoService leerArchivoService;

	@GetMapping("/leer")
	public @ResponseBody String leerArchivo(){
		return leerArchivoService.leerArchivo();
	}
}
