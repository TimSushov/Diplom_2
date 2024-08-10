import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resours.Credential;
import steps.OrderSteps;
import steps.UserSteps;

import java.util.ArrayList;

public class CreateOrderTest {
    private String email = Credential.EMAIL;
    private String password = Credential.PASSWORD;
    private String name = Credential.NAME;
    private String random = Credential.RANDOM;
    ArrayList<String> ingredients = new ArrayList<>();

    UserSteps userSteps = new UserSteps();
    OrderSteps orderSteps = new OrderSteps();

    @Before
    public void createUser() {
        userSteps.createUser(email, password, name, 200);
    }

    @Test
    @DisplayName("Создание заказа без ингридиентов")
    @Description("Заказ не создается")
    public void createOrderWithoutIngredient() {
        String token = userSteps.getToken(email, password);
        orderSteps.getIngredients();
        orderSteps.createOrder(ingredients, 400, "");
        orderSteps.createOrder(ingredients, 400, token);
    }

    @Test
    @DisplayName("Создание заказа c ингридиентами")
    @Description("Заказ создается")
    public void createOrderWithIngredient() {
        String token = userSteps.getToken(email, password);
        ingredients = orderSteps.getIngredients();
        orderSteps.createOrder(ingredients, 200, "");
        orderSteps.createOrder(ingredients, 200, token);
    }

    @Test
    @DisplayName("Создание заказа c неверными ингридиентами")
    @Description("Заказ не создается")
    public void createOrderWithWrongIngredient() {
        String token = userSteps.getToken(email, password);
        ingredients.add("11d3b41abdacab0026a733c6");
        orderSteps.createOrder(ingredients, 400, "");
        orderSteps.createOrder(ingredients, 400, token);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUser(userSteps.getToken(email, password));
    }

}
