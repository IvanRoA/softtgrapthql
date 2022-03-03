package com.ivra.graphql.graphql.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Archivo;
import com.ivra.graphql.graphql.model.CatalogoT;
import com.ivra.graphql.graphql.repository.ArchivoRepository;
import com.ivra.graphql.graphql.repository.CatalogoTRepository;
import com.ivra.graphql.graphql.service.LeerArchivoService;

@Service
public class LeerArchivoServiceImpl implements LeerArchivoService {
	
	@Autowired
	private CatalogoTRepository coloniaRepository;
	
	@Autowired
	private ArchivoRepository archivoRepository;

	public String leerArchivo() {
		Path path = Paths.get("./src/main/resources/archivo.txt");

		try (Stream<String> registro = Files.lines(path)){
			registro.forEach(
					reg -> {
							List<String> cols= Pattern.compile(Pattern.quote("|")).splitAsStream(reg).collect(Collectors.toList());
							CatalogoT catalogoT = new CatalogoT(LocalTime.parse(cols.get(0)),
									cols.get(1), new BigDecimal(cols.get(2)), cols.get(3), cols.get(4), cols.get(5), cols.get(6), cols.get(7), cols.get(8), cols.get(9), cols.get(10),
									cols.get(11), cols.get(12), cols.get(13), new BigDecimal(cols.get(14)), new BigDecimal(cols.get(15)), cols.get(16), cols.get(17), Integer.parseInt(cols.get(18)),
									new BigDecimal(cols.get(19)), cols.get(20), cols.get(21), cols.get(22), cols.get(23), new BigDecimal(cols.get(24)), cols.get(25), new BigDecimal(cols.get(26)),
									cols.get(27), cols.get(28), cols.get(29));
							coloniaRepository.save(catalogoT);
						}
					);
			archivoRepository.save(new Archivo(path.getFileName().toString(), LocalDate.now()));
			copiarArchivo(path);
		} catch (IOException e){
			e.printStackTrace();
			throw new RuntimeException("No se ha encontrado el archivo");
		}
		return "true";
	}
	
	public void copiarArchivo(Path origen) {
		Path destino = Paths.get("./src/main/resources/copias/archivo.txt");
		
		try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        	e.printStackTrace();
        	throw new RuntimeException("No se ha podido crear el archivo");
        }
	}
}
