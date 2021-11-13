package com.devappron.backendjava;

import com.devappron.backendjava.utils.AppPropiedades;
import com.devappron.backendjava.models.respuestas.UsuarioRestModel;
import com.devappron.backendjava.shared.UsuarioDto;
import com.devappron.backendjava.utils.AppContexto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class BackendjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendjavaApplication.class, args);
		System.out.println("¡Despliegue de Api exitoso!");
	}


	@Bean
	public ModelMapper modelmapper(){

		ModelMapper modelmapper = new ModelMapper();

		modelmapper.typeMap(UsuarioDto.class, UsuarioRestModel.class).addMappings(m->m.skip(UsuarioRestModel::setEntradaRestModelList));

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



