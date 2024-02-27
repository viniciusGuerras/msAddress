package com.compassuol.sp.challenge.msaddress.domain.service;

import com.compassuol.sp.challenge.msaddress.domain.model.Address;
import com.compassuol.sp.challenge.msaddress.domain.exception.CepNotValidException;
import com.compassuol.sp.challenge.msaddress.domain.repository.AddressRepository;
import com.compassuol.sp.challenge.msaddress.openfeign.CepConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    private final CepConsumer cepConsumer;

    public Long save(String cep) {
        cep = cep.replace("-", "");
        if (isCepValid(cep)){
            Address address =  addressRepository.findByCep(cep);
            if (address == null){
                Address foundAddress = cepConsumer.getAddress(cep);
                foundAddress.setCep(cep);
                return addressRepository.save(foundAddress).getId();
            }
            else {
                return address.getId();
            }

        }
        else {
            throw new CepNotValidException("Incorrect Cep Format");
        }
    }

    private boolean isCepValid(String cep){
        String regex = "^\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }
}
