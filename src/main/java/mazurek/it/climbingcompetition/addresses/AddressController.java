package mazurek.it.climbingcompetition.addresses;

import mazurek.it.climbingcompetition.BasicController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddressController extends BasicController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping("/address")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }
}
