package com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper;

import com.compassuol.sp.challenge.msaddress.domain.web.dto.AddressResponseDto;


public class AddressMapper {

    public static AddressResponseDto toDto(Long id){
        return new AddressResponseDto(id);
    }
}
