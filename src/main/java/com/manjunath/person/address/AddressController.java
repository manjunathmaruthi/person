package com.manjunath.person.address;

import com.manjunath.person.address.exception.AddressNotFoundException;
import com.manjunath.person.address.service.AddressService;
import com.manjunath.person.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(consumes = "application/json")
    public @ResponseBody HttpStatus addAddressToPerson(@RequestBody List<Address> addressList,
                                                       @RequestParam long personId) throws Exception {
        for(Address address : addressList) {
            addressService.addAddressToPerson(address, personId);
        }
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public @ResponseBody HttpStatus editAddress(@PathVariable("id") long id, @RequestBody Address address) throws Exception {
        addressService.editAddress(id,address);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody HttpStatus deletePerson(@PathVariable("id") Long id) throws AddressNotFoundException {
        addressService.deleteAddress(id);
        return HttpStatus.OK;
    }
}
