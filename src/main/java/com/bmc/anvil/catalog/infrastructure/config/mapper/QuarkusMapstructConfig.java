package com.bmc.anvil.catalog.infrastructure.config.mapper;

import com.bmc.anvil.catalog.adapters.in.rest.dtos.requests.CatalogCreateDTO;
import com.bmc.anvil.catalog.adapters.in.rest.mappers.common.IdMapper;
import com.bmc.anvil.catalog.domain.models.entities.Catalog;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

/**
 * MapStruct central configuration.
 * <p>
 * Expected Usage:<br>
 * All mapper interfaces in the project should use this configuration to avoid boilerplate.
 * <p>
 * General mapper helpers like {@link IdMapper}, should go here so they are injected on every mapper. Other helpers with
 * limited use to particular classes should only be used where they belong.
 *
 * @author BareMetalCode
 */
@MapperConfig(componentModel = "jakarta",
              uses = {IdMapper.class},
              mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface QuarkusMapstructConfig {

    /**
     * This is a prototype mapping method as described in
     * <a href="https://mapstruct.org/documentation/stable/reference/html/#shared-configurations">mapstruct shared configuration</a>.
     * <p>
     * This method will not be implemented, but it is meant for mapstruct to inherit the mapping configuration down to the other mapping interfaces.
     * <p>
     * In this case, as we internally create timestamps and Id, the creation item will have neither, so we ignore them.
     *
     * @param catalogCreateDto the base {@link CatalogCreateDTO} DTO a given input will extend.
     *
     * @return a catalog object extending {@link Catalog}.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationTimes", ignore = true)
    @Mapping(target = "isSystem", ignore = true)
    Catalog fromCreateDto(CatalogCreateDTO catalogCreateDto);

}
