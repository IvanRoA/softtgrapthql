package com.ivra.graphql.graphql.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Archivo;
import com.ivra.graphql.graphql.model.Colonia;
import com.ivra.graphql.graphql.repository.ArchivoRepository;
import com.ivra.graphql.graphql.repository.ColoniaRepository;
import com.ivra.graphql.graphql.service.LeerArchivoService;

@Service
public class LeerArchivoServiceImpl implements LeerArchivoService {
	
	@Autowired
	private ColoniaRepository coloniaRepository;
	
	@Autowired
	private ArchivoRepository archivoRepository;

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
			archivoRepository.save(new Archivo(path.getFileName().toString(), LocalDate.now()));
			copiarArchivo(path);
		} catch (IOException e){
			e.printStackTrace();
		}
		return "true";
	}
	
	public void copiarArchivo(Path origen) {
		Path destino = Paths.get("./src/main/resources/copias/archivo.txt");
		
		try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
}
