import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class UpdateUserWithAuthTest {
    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;
    private String random = Credential.RANDOM;

    UserSteps userSteps= new UserSteps();;

    @Before
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
    }

    @Test
    @DisplayName("Изменение емейла пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserEmail() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email + random, password, name, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение пароля пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserPassword() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email, password + random, name, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение имени пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserName() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email, password, name + random, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение емейла и имени пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserEmailName() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email + random, password, name + random, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение емейла и пароля пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserEmailPassword() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email + random, password+ random, name, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение пароля и имени пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserPasswordName() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email, password + random, name+ random, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @Test
    @DisplayName("Изменение емейла, пароля и имени пользователя с авторизацией")
    @Description("Данные изменены")
    public void UpdateUserEmailPasswordName() {
        String token = userSteps.getToken(email, password);
        userSteps.updateUser(email + random, password+ random, name + random, 200, token);
        userSteps.updateUser(email, password, name, 200, token);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }
}

