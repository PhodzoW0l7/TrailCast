package com.trailcast.TrailCast.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class users implements userDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstname;
    private String lastname;

    @Column(unique=true, nullable = false)
    private String username;
    @Column(unique=true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

//    public void generateUsername(UserService userService) { // Pass a service to check DB
//        String baseUsername = (this.firstName.charAt(0) + this.lastName).toLowerCase();
//        String uniqueUsername = baseUsername;
//        int counter = 1;
//
//        // Loop until a unique username is found
//        while (userService.isUsernameTaken(uniqueUsername)) {
//            uniqueUsername = baseUsername + counter;
//            counter++;
//        }
//        this.username = uniqueUsername;
//    }

}
