import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class CreateUserTest {

    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;

    UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Создание пользователя")
    @Description("Пользователь создается без ошибок")
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
        userSteps.deleteUser(userSteps.getToken(email, password));
    }

    @Test
    @DisplayName("Создание существующего пользователя")
    @Description("Пользователь не созадется повторно")
    public void createUserAlreadyExists() {
        userSteps.createUser(email, password, name, 200);
        userSteps.createUser(email, password, name, 403);
        userSteps.deleteUser(userSteps.getToken(email, password));
    }

    @Test
    @DisplayName("Создать пользователя без обязательных полей.")
    @Description("Пользователь  созадется повторно")
    public void createUserWithoutField() {
        userSteps.createUser("", password, name, 403);
        userSteps.createUser(email, "", name, 403);
        userSteps.createUser(email, password, "", 403);
    }

}
