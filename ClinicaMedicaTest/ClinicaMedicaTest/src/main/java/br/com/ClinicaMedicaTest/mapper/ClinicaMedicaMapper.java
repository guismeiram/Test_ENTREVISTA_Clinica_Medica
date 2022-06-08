package br.com.ClinicaMedicaTest.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.List;

import org.modelmapper.Converters.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.model.Consulta;

@Configuration
public class ClinicaMedicaMapper {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    /*public ClinicaMedicaMapper(List<Consulta> consulta) {
        Converter<Consulta, ConsultaDTO> installationConverter = new Converter<Consulta, ConsultaDTO>() {
            public ConsultaDTO convert(MappingContext<Consulta, ConsultaDTO> context) {
                ConsultaDTO dto = new ConsultaDTO(List<Consultorio> consultorio, List<Medico> medico);
                dto.setId(consulta.geId());
                dto.setName(installation.getName());
                dto.setDescription(installation.getDescription());
                return dto;
            }

			@Override
			public ConsultaDTO convert(Consulta source) {
				// TODO Auto-generated method stub
				return null;
			}
        };
        mapper.addConverter(installationConverter);

        Type listType = new TypeToken<List<InstallationDTO>>() {}.getType();
        this.installation = mapper.map(installation, listType);
    }*/

}
