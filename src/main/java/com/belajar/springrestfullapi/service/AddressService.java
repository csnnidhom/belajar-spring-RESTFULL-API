package com.belajar.springrestfullapi.service;

import com.belajar.springrestfullapi.entity.Address;
import com.belajar.springrestfullapi.entity.Contact;
import com.belajar.springrestfullapi.entity.User;
import com.belajar.springrestfullapi.model.AddressResponse;
import com.belajar.springrestfullapi.model.CreateAddressRequest;
import com.belajar.springrestfullapi.repository.AddressRepository;
import com.belajar.springrestfullapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    public AddressResponse create(User user, CreateAddressRequest request){
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId())
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setContact(contact);
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());

        addressRepository.save(address);

        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(request.getProvince())
                .country(request.getCountry())
                .postalCode(request.getPostalCode())
                .build();
    }

}
