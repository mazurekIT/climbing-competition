package mazurek.it.climbingcompetition.service;

import mazurek.it.climbingcompetition.repository.AddressRepository;
import mazurek.it.climbingcompetition.exceptions.AddressNotFoundException;
import mazurek.it.climbingcompetition.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }
}
