package mazurek.it.climbingcompetition.controller.view;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.model.Address;
import mazurek.it.climbingcompetition.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view/v1/addresses")
@RequiredArgsConstructor
public class AddressViewController {
    private final AddressService addressService;

    @GetMapping
    public String addressesView(Model model){
        model.addAttribute("addresses",addressService.findAll());
        return "addressesView";
    }

    @GetMapping( "/add")
    public String displayAddAddress(Model model) {
        model.addAttribute("address", new Address());
        return "addAddressForm";
    }

    @PostMapping(value = "/add")
    public String addAddress(Model model, @ModelAttribute("address") Address address) {
        addressService.addAddress(address);
//        model.addAttribute("addresses", addressService.findAll());
        return "redirect:/view/v1/addresses";
    }
}
