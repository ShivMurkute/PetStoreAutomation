package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Endpoints {
    public static Response createuser(User payload) {
        Response response;
        response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routs.post_url);
        return response;


    }
    public static Response readuser(String userName) {
        Response response=(Response) given()
                .pathParam("username", userName)
                .when()
                .get(Routs.get_url);
        return response;
    }
    public static Response updateuser(String userName,User payload) {
        Response response=(Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routs.update_url);
        return response;
    }
    public static Response deleteuser(String userName) {
        Response response=(Response) given()
                .pathParam("username", userName)
                .when()
                .delete(Routs.delete_url);
        return response;
    }
}


