package com.codegym.rentapartmentbe.controller;

import com.codegym.rentapartmentbe.Form.SignUpForm;
import com.codegym.rentapartmentbe.entity.LandLord;
import com.codegym.rentapartmentbe.entity.Role;
import com.codegym.rentapartmentbe.entity.RoleName;
import com.codegym.rentapartmentbe.repository.LandLordRepository;
import com.codegym.rentapartmentbe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class SignUpController {
    @Autowired
    private LandLordRepository landLordRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest ){
        if (landLordRepository.existsByName(signUpRequest.getName())){
            return new ResponseEntity<>("Name taken", HttpStatus.BAD_REQUEST);
        }
        if (landLordRepository.existsByEmail(signUpRequest.getEmail())){
            return new ResponseEntity<>("Email already used", HttpStatus.BAD_REQUEST);
        }
        LandLord landLord = new LandLord(
                signUpRequest.getFullName(),
                signUpRequest.getName(),
                signUpRequest.getEmail(),
                signUpRequest.getPhoneNumber(),
                passwordEncoder.encode(signUpRequest.getPassWord()) );
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role){
                case "ADMIN":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(()-> new RuntimeException("Fail -> Cause: User Role not find."));
                    roles.add(adminRole);
                    break;
                case "LANDLORD":
                    Role landLordRole = roleRepository.findByName(RoleName.ROLE_LANDLORD)
                            .orElseThrow(() -> new RuntimeException("Fail -> Cause: User Role not find."));
                    roles.add(landLordRole);

            }
        });
        landLord.setRoles(roles);
        landLordRepository.save(landLord);
        return new ResponseEntity<>("registered successfully", HttpStatus.OK);
    }
}
