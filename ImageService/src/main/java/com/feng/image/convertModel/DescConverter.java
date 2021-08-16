package com.feng.image.convertModel;

import com.feng.image.DTO.DescDTO;
import com.feng.image.DTO.ModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author feng
 */
@Mapper
public interface DescConverter {
    DescConverter INSTANCE = Mappers.getMapper(DescConverter.class);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "desc")
    })
    DescDTO domain2dto(ModelDTO modelDTO);

}
