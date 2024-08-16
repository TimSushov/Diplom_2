package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import resours.RequestSpec;
import resours.Urls;
import resours.bodyData.OrderData;
import resours.responseData.Data;
import resours.responseData.GetIngredientsResponse;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderSteps extends RequestSpec {

    @Step("Create order")
    public void createOrder(ArrayList<String> ingredients, int statusCode, String bearerToken) {
        OrderData orderData = new OrderData(ingredients);
        Response response =
                given()
                        .spec(requestSpec())
                        .header("Content-type", "application/json")
                        .headers("authorization", bearerToken)
                        .and()
                        .body(orderData)
                        .when()
                        .post(Urls.ORDER_CREATE_GET);
        response.then().statusCode(statusCode);
        if (statusCode == 200) {
            response.then().assertThat().body("success", equalTo(true));
        } else if (statusCode == 400) {
            response.then().assertThat().body("success", equalTo(false));
        } else if (statusCode == 403) {
            response.then().assertThat().body("success", equalTo(false));
        } else if (statusCode == 500) {
            response.then().assertThat().body("success", equalTo(false));
        }
    }

    @Step("Get order user")
    public void getOrderUser(int statusCode, String bearerToken){
        Response response =
                given()
                        .spec(requestSpec())
                        .header("Content-type", "application/json")
                        .headers("authorization", bearerToken)
                        .when()
                        .get(Urls.ORDER_CREATE_GET);
        response.then().statusCode(statusCode);
        if (statusCode == 200) {
            response.then().assertThat().body("success", equalTo(true));
        } else if (statusCode == 401) {
            response.then().assertThat().body("success", equalTo(false));
        }
    }

    @Step("Get ingredients")
    public ArrayList<String> getIngredients() {
        GetIngredientsResponse getIngredientsResponse =
                given()
                        .spec(requestSpec())
                        .header("Content-type", "application/json")
                        .when()
                        .get(Urls.GET_INGREDIENTS)
                        .body().as(GetIngredientsResponse.class);

        List<Data> dataList = getIngredientsResponse.getData();
        ArrayList<String> ingredientsList = new ArrayList<>();
        Data data;
        for (int i = 0; i < dataList.size(); i++){
            data = dataList.get(i);
            ingredientsList.add(data.get_id());
        }

        return ingredientsList;
    }
}
