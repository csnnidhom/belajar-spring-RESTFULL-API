package com.belajar.springrestfullapi.controller;

import com.belajar.springrestfullapi.entity.User;
import com.belajar.springrestfullapi.model.AddressResponse;
import com.belajar.springrestfullapi.model.CreateAddressRequest;
import com.belajar.springrestfullapi.model.WebResponse;
import com.belajar.springrestfullapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest createAddressRequest,
                                               @PathVariable("contactId") String contactId
                                               ){
        createAddressRequest.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, createAddressRequest);
        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> get(User user,
                                            @PathVariable("contactId") String contactId,
                                            @PathVariable("addressId") String addressId
                                            ){
        AddressResponse addressResponse = addressService.get(user,contactId, addressId);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }



}
