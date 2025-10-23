package tlaq.com.backendV64.dto.request;


import tlaq.com.backendV64.entity.Role;

import java.time.LocalDate;
import java.util.List;

public class UpdateUserRequest {
    String password;
    String firstName;
    String lastName;

    LocalDate dob;

    List<Role> roles;
}
