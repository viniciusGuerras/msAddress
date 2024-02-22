package com.compassuol.sp.challenge.msaddress.domain.web;

import com.compassuol.sp.challenge.msaddress.domain.service.AddressService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep/")
public class AddressController {

    private AddressService addressService;

    @PostMapping("{cep}")
    public ResponseEntity<Void> saveAddress(@PathVariable("cep") String cep){
        addressService.save(cep);
        return ResponseEntity.ok().build();
    }
}
