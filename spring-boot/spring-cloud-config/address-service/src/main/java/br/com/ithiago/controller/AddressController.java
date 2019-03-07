package br.com.ithiago.controller;

import br.com.ithiago.model.Address;
import br.com.ithiago.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thiago on 12/30/18.
 */

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address/create")
    public String createClient(@RequestBody Address address) {
        return addressService.createClient(address);
    }

    @GetMapping("address/all")
    public List<Address> getAll() {
        return addressService.getAll();
    }
}
