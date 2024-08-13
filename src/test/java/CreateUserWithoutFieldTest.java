import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class CreateUserWithoutFieldTest {

    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;

    UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Создать пользователя без обязательных полей.")
    @Description("Пользователь не созадется")
    public void createUserWithoutEmail() {
        userSteps.createUser("", password, name, 403);
    }

    @Test
    @DisplayName("Создать пользователя без обязательных полей.")
    @Description("Пользователь не созадется")
    public void createUserWithoutPassword() {
        userSteps.createUser(email, "", name, 403);
    }

    @Test
    @DisplayName("Создать пользователя без обязательных полей.")
    @Description("Пользователь не созадется")
    public void createUserWithoutName() {
        userSteps.createUser(email, password, "", 403);
    }
}
