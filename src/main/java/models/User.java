package models;

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

    public User(String email, Gender gender, String firstName, String lastName, String password, String street, String city, String state, String postalCode, String country, String phone, String alias) {
        this.email = email;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getAlias() {
        return alias;
    }

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
            if (password.isEmpty() || password.length()<5) {
                throw new IllegalStateException("Password cannot be empty or is too short");
            }
            return new User(email, gender, firstName, lastName, password, street, city, state, postalCode, country, phone, alias);
        }
    }
}
