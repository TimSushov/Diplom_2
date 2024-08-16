import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.OrderSteps;
import steps.UserSteps;

import java.util.ArrayList;

public class GetOrderUser {
    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;
    ArrayList<String> ingredients = new ArrayList<>();

    UserSteps userSteps = new UserSteps();
    OrderSteps orderSteps = new OrderSteps();

    @Before
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
    }

    @Test
    @DisplayName("Получить заказы без авторизации")
    @Description("Заказы не отображаются в ответе")
    public void getOrderUserWithoutAuth() {
        orderSteps.getOrderUser(401, "");
    }

    @Test
    @DisplayName("Получить заказы c авторизацией")
    @Description("Заказы отображаются в ответе")
    public void getOrderUserWithAuth() {
        String token = userSteps.getToken(email, password);
        ingredients = orderSteps.getIngredients();
        orderSteps.createOrder(ingredients, 200, token);
        orderSteps.getOrderUser(200, token);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }
}
