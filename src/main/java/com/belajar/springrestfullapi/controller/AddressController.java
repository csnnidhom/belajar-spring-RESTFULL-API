package com.belajar.springrestfullapi.controller;

import com.belajar.springrestfullapi.entity.User;
import com.belajar.springrestfullapi.model.AddressResponse;
import com.belajar.springrestfullapi.model.CreateAddressRequest;
import com.belajar.springrestfullapi.model.WebResponse;
import com.belajar.springrestfullapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses"
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
}
