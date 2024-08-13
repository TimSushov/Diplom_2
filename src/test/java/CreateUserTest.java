import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class CreateUserTest {

    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;

    UserSteps userSteps = new UserSteps();

    @Before
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
    }

    @Test
    @DisplayName("Создание пользователя")
    @Description("Пользователь создается без ошибок, получаем его токен")
    public void createUserGetToken() {
        userSteps.getToken(email, password);
    }

    @Test
    @DisplayName("Создание существующего пользователя")
    @Description("Пользователь не созадется повторно")
    public void createUserAlreadyExists() {
        userSteps.createUser(email, password, name, 403);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }
}
