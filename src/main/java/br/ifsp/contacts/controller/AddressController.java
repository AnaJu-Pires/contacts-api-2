package br.ifsp.contacts.controller;


import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }


    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado: " + addressId));
    }

}
