package br.com.ithiago.service;

import br.com.ithiago.model.Address;
import br.com.ithiago.repository.AddressRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thiago on 12/30/18.
 */

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public String createClient(Address address) {
        addressRepository.save(address);

        return "Address saved with success!!!";
    }

    public List<Address> getAll() {
        return Lists.newArrayList(addressRepository.findAll());
    }
}
