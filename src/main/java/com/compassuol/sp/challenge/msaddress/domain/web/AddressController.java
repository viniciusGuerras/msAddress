package com.compassuol.sp.challenge.msaddress.domain.web;

import com.compassuol.sp.challenge.msaddress.domain.service.AddressService;

import com.compassuol.sp.challenge.msaddress.domain.web.dto.AddressResponseDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.CepDto;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.AddressMapper;
import com.compassuol.sp.challenge.msaddress.domain.web.dto.mapper.CepMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/address")
@RequiredArgsConstructor
@Tag(name = "Address Controller", description = "Endpoints for managing addresses")
public class AddressController {

    public final AddressService addressService;

    @Operation(
            summary = "Saves address",
            description = "Saves a new address in the database",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Address saved"
                            , content = @Content(mediaType = "application/json", schema = @Schema(implementation = AddressResponseDto.class)))

            })
    @PostMapping()
    public ResponseEntity<AddressResponseDto> saveAddress(@RequestBody CepDto cep){
        Long id =  addressService.save(CepMapper.toCep(cep));
        return ResponseEntity.ok().body(AddressMapper.toDto(id));
    }
}
