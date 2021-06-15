package providers;

import models.Gender;
import models.User;


public class UserFactory {

    public User getAlreadyRegisteredUser() {
        return User.builder()
                .email("abcdtest@wp.pl")
                .gender(Gender.FEMALE)
                .firstName("Anna")
                .lastName("Kowalska")
                .password("qazws1@")
                .street("ulica1")
                .city("Warsaw")
                .state("Alabama")
                .postalCode("02756")
                .country("United States")
                .phone("234567")
                .alias("adres1")
                .build();
    }

    public User getRandomUser() {
        RandomStringGenerator rnd = new RandomStringGenerator();

        return User.builder()
                .email(rnd.getRandomEmail(7))
                .gender(Gender.getRandomGender())
                .firstName(rnd.getRandomString(6))
                .lastName(rnd.getRandomString(10))
                .password(rnd.getRandomPassword(8))
                .street(rnd.getRandomString(8))
                .city(rnd.getRandomString(5))
                .state("Alabama")
                .postalCode(rnd.getRandomNumbers(5))
                .country("United States")
                .phone(rnd.getRandomNumbers(6))
                .alias(rnd.getRandomString(5))
                .build();
    }
}