package com.compassuol.sp.challenge.msaddress.domain.web;

import com.compassuol.sp.challenge.msaddress.domain.service.AddressService;

import com.compassuol.sp.challenge.msaddress.domain.web.dto.AddressResponseDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.CepDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.AddressMapper;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.CepMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/address")
@RequiredArgsConstructor
public class AddressController {

    public final AddressService addressService;

    @PostMapping()
    public ResponseEntity<AddressResponseDto> saveAddress(@RequestBody CepDto cep){
        Long id =  addressService.save(CepMapper.toCep(cep));
        return ResponseEntity.ok().body(AddressMapper.toDto(id));
    }
}
