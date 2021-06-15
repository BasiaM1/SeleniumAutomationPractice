package AutomationPractice;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.RegistrationPage;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest extends TestBase {

    @Test
    public void shouldRegisterNewUser()  {
        User user = new UserFactory().getRandomUser();
        homePage.getMenu()
                .openLoginPage()
                .openRegisterPage(user)
                .registerUser(user);

        assertThat(homePage.getMenu().getUserName(),
                equalTo(user.getFirstName() + " " + user.getLastName()));

    }

    @Test
    public void shouldHoverMouseOnElement(){
     homePage.getMenu()
             .mouseHoverWoman()
             .mouseHoverDress()
             .mouseHoverTshirt();
    }
}