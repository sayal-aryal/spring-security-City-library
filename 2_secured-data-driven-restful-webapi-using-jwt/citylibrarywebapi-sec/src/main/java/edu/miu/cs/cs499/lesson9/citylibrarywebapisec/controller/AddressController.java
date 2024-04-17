package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.controller;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.AddressResponse2;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl.AddressServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/citylibrary/api/v1/address"})
public class AddressController {

    private AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<AddressResponse2>> listAddress() {
        return ResponseEntity.ok(addressService.getAddresses());
    }
}
