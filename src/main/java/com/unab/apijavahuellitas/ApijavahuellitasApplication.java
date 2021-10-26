package com.unab.apijavahuellitas;

import com.unab.apijavahuellitas.utils.AppPropiedades;
import com.unab.apijavahuellitas.models.respuestas.UsuarioRestModel;
import com.unab.apijavahuellitas.shared.UsuarioDTO;
import com.unab.apijavahuellitas.utils.AppContexto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class ApijavahuellitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApijavahuellitasApplication.class, args);
		System.out.println("¡Despliegue de Api exitoso!");
	}

	@Bean
	public ModelMapper modelmapper(){

		ModelMapper modelmapper=new ModelMapper();

		modelmapper.typeMap(UsuarioDTO.class, UsuarioRestModel.class).addMappings(m->m.skip(UsuarioRestModel::setPartidoRestModelList));

		return modelmapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean(name="AppProperties")
	public AppPropiedades getAppProperties(){
		return new AppPropiedades();
	}

	@Bean
	public AppContexto springApplicationContext(){
		return new AppContexto();
	}

}