package mazurek.it.climbingcompetition.controller;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.model.Address;
import mazurek.it.climbingcompetition.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressController extends BasicController {
    private final AddressService addressService;

    @GetMapping
    public String addressesView(Model model){
        model.addAttribute("addresses",addressService.findAll());
        return "addressesView";
    }

//    @GetMapping
//    public List<Address> getAddresses() {
//        return addressService.findAll();
//    }

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
