package com.compassuol.sp.challenge.msaddress.domain.service;

import com.compassuol.sp.challenge.msaddress.domain.Entity.Address;
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
public class AddressService {

    private final AddressRepository addressRepository;

    private final CepConsumer cepConsumer;

    public void save(String cep) {

        if(cep.charAt(5) == '-'){
            cep = cep.replace("-", "");
        }

        if (isCepValid(cep)){
            Address address = cepConsumer.getAddress(cep);
            address.setCep(cep);
            addressRepository.save(address);
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
