package mazurek.it.climbingcompetition.addresses;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.BasicController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressController extends BasicController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.findAll();
    }

    @GetMapping("{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@Valid @RequestBody Address address) {
        return addressService.addAddress(address);
    }
}
