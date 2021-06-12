package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
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


    public static final class Builder {
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

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

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
}


