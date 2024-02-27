package com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper;

import com.compassuol.sp.challenge.msaddress.domain.web.dto.CepDto;

public class CepMapper {

    public static String toCep(CepDto cep){
        return cep.getCep();
    }
}
