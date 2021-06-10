package AutomationPractice;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends TestBase {
    private User user;
    private String expectedSignInText;

    @BeforeEach
    public void testSetUp() {
        user = new UserFactory().getAlreadyRegisteredUser();
        expectedSignInText = user.getFirstName() + " " + user.getLastName();
    }

    @Test
    public void shouldLoginUser() {
        homePage.getMenu()
                .openLoginPage()
                .login(user);

        String actualSignInText = homePage.getMenu().getUserName();
        assertThat(actualSignInText,
                equalTo(expectedSignInText));
    }
}

