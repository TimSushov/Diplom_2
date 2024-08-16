import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import resours.Credential;
import steps.UserSteps;

public class UpdateUserWithoutAuthTest {
    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;
    private String random = Credential.RANDOM;

    UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Изменение емейла пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserEmailWithoutAuth() {
        String token = "";
        userSteps.updateUser(email + random, password, name, 401, token);
    }

    @Test
    @DisplayName("Изменение пароля пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserPasswordWithoutAuth() {
        String token = "";
        userSteps.updateUser(email, password + random, name, 401, token);
    }

    @Test
    @DisplayName("Изменение имени пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserNameWithoutAuth() {
        String token = "";
        userSteps.updateUser(email, password, name + random, 401, token);
    }

    @Test
    @DisplayName("Изменение емейла и имени пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserEmailNameWithoutAuth() {
        String token = "";
        userSteps.updateUser(email + random, password, name + random, 401, token);
    }

    @Test
    @DisplayName("Изменение емейла и пароля пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserEmailPasswordWithoutAuth() {
        String token = "";
        userSteps.updateUser(email + random, password+ random, name, 401, token);
    }

    @Test
    @DisplayName("Изменение пароля и имени пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserPasswordNameWithoutAuth() {
        String token = "";
        userSteps.updateUser(email, password + random, name+ random, 401, token);
    }

    @Test
    @DisplayName("Изменение емейла, пароля и имени пользователя без авторизации")
    @Description("Данные не изменены")
    public void UpdateUserEmailPasswordNameWithoutAuth() {
        String token = "";
        userSteps.updateUser(email + random, password+ random, name + random, 401, token);
    }
}
