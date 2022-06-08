package mazurek.it.climbingcompetition.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {


    private String fullName;
    private String phone;
    private String mail;
    private String role; // TODO i think it is unnecessary
    private String gender;
    private String fullAddress;
    private List<String> wallsName = new ArrayList<>();

}
