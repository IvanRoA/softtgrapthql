package com.ivra.graphql.graphql.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Colonia;
import com.ivra.graphql.graphql.repository.ColoniaRepository;
import com.ivra.graphql.graphql.service.LeerArchivoService;

@Service
public class LeerArchivoServiceImpl implements LeerArchivoService {
	
	@Autowired
	private ColoniaRepository coloniaRepository;

	public String leerArchivo() {
		Path path = Paths.get("./src/main/resources/archivo.txt");

		try (Stream<String> registro = Files.lines(path)){
			registro.forEach(
					reg -> {
							List<String> cols= Pattern.compile(Pattern.quote("|")).splitAsStream(reg).collect(Collectors.toList());
							Colonia colonia = new Colonia(cols.get(7), cols.get(1), cols.get(2), cols.get(3), cols.get(4), cols.get(5), cols.get(6), Integer.parseInt(cols.get(0)));
							coloniaRepository.save(colonia);
						}
					);
		} catch (IOException e){
			e.printStackTrace();
		}
		return "True";
	}
}
