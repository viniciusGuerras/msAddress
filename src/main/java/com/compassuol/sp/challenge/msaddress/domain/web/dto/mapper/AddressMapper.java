package com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper;

import com.compassuol.sp.challenge.msaddress.domain.Entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.AddressDto;
import org.modelmapper.ModelMapper;

public class AddressMapper {

    public static AddressDto toDto(Address address){
        return new ModelMapper().map(address, AddressDto.class);
    }

    public static Address toAddress(AddressDto dto){
        return new ModelMapper().map(dto, Address.class);
    }
}
