package com.compassuol.sp.challenge.msaddress.domain.web;

import com.compassuol.sp.challenge.msaddress.domain.Entity.Address;
import com.compassuol.sp.challenge.msaddress.domain.service.AddressService;

import com.compassuol.sp.challenge.msaddress.domain.web.dto.AddressDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.CepDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.AddressMapper;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.CepMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {

    public final AddressService addressService;

    @PostMapping()
    public ResponseEntity<Long> saveAddress(@RequestBody CepDto cep){
        Long id =  addressService.save(CepMapper.toCep(cep));
        return ResponseEntity.ok().body(id);
    }
}
