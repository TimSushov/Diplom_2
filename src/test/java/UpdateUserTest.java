import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class UpdateUserTest {
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
    @DisplayName("Изменение данных пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUser() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email + random, password, name, 200, token);
        userSteps.updateUser(email, password + random, name, 200, token);
        userSteps.updateUser(email + random, password, name + random, 200, token);
        userSteps.updateUser(email + random, password+ random, name, 200, token);
        userSteps.updateUser(email, password + random, name+ random, 200, token);
        userSteps.updateUser(email + random, password, name + random, 200, token);
        userSteps.updateUser(email + random, password+ random, name + random, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение данных пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserWithoutAurh() {
        String token = "";
        userSteps.updateUser(email + random, password, name, 401, token);
        userSteps.updateUser(email, password + random, name, 401, token);
        userSteps.updateUser(email + random, password, name + random, 401, token);
        userSteps.updateUser(email + random, password+ random, name, 401, token);
        userSteps.updateUser(email, password + random, name+ random, 401, token);
        userSteps.updateUser(email + random, password, name + random, 401, token);
        userSteps.updateUser(email + random, password+ random, name + random, 401, token);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }
}

