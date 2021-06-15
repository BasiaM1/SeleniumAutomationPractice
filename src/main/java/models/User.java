package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class User {
    private String email;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String password;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String alias;

        public User build() {
            if (email.isEmpty()) {
                throw new IllegalStateException("Email cannot be empty");
            }
            if (password.isEmpty() || password.length() < 5) {
                throw new IllegalStateException("Password cannot be empty or is too short");
            }
            return new User(email, gender, firstName, lastName, password, street, city, state, postalCode, country, phone, alias);
        }
    }



