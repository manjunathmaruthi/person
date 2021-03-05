package com.manjunath.person.address.service;

import com.manjunath.person.address.dao.AddressDAO;
import com.manjunath.person.address.exception.AddressNotFoundException;
import com.manjunath.person.dao.PersonDAO;
import com.manjunath.person.exception.PersonNotFoundException;
import com.manjunath.person.model.Address;
import com.manjunath.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private PersonDAO personDAO;

    public void addAddressToPerson(Address address, long personId) throws Exception {
        Optional<Person> person = personDAO.findById(personId);
        if(person.isPresent()){
            address.setPerson(person.get());
            addressDAO.save(address);
        } else {
            throw new Exception(String.format("Unable to add address, Person not found for given id: %d",personId));
        }

    }

    public void editAddress(long id,Address address) throws Exception {
        Optional<Address> addressOptional = addressDAO.findById(id);
        if(addressOptional.isPresent()){
            address.setId(id);
            addressDAO.save(address);
        } else {
            throw new Exception(String.format("Unable to edit address, address not found for given id: %d",id));
        }

    }

    public void deleteAddress(Long id) throws AddressNotFoundException {
        Optional<Address> address = addressDAO.findById(id);
        if (address.isPresent()) {
            addressDAO.deleteById(id);
        } else {
            throw new AddressNotFoundException("No address found for given id: " + id);
        }
    }
}
