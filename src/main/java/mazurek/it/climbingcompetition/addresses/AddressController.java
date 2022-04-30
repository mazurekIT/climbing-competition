package mazurek.it.climbingcompetition.addresses;

import mazurek.it.climbingcompetition.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController extends BasicController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/address")
    public List<Address> getAll(){
        return addressService.findAll();
    }
}
