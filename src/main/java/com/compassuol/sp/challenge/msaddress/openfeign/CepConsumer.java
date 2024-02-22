package com.compassuol.sp.challenge.msaddress.openfeign;

import com.compassuol.sp.challenge.msaddress.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address", url = "viacep.com.br/")
public interface CepConsumer {

    @GetMapping(value = "ws/{cep}/json/")
    Address getAddress(@PathVariable("cep") String cep);
}
