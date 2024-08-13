import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class LoginUserTest {
    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;
    private String random = Credential.RANDOM;

    UserSteps userSteps = new UserSteps();

    @Before
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
    }

    @Test
    @DisplayName("Логин пользователя")
    @Description("Авторизация успешна")
    public void loginUser() {
       userSteps.loginUser(email, password, 200);
    }

    @Test
    @DisplayName("Логин пользователя с неверным логином")
    @Description("Авторизация не происходит")
    public void loginUserWitWrongLogin() {
        userSteps.loginUser(email + random, password, 401);
    }

    @Test
    @DisplayName("Логин пользователя с неверным паролем")
    @Description("Авторизация не происходит")
    public void loginUserWitWrongPassword() {
        userSteps.loginUser(email, password + random, 401);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }
}
