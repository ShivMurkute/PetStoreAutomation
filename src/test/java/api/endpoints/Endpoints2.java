package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class Endpoints2 {

  //method created for getting URL from properties file
   static ResourceBundle getURL(){
 ResourceBundle routes=ResourceBundle.getBundle("routs");//Load propertis file
 return routes;
   }

    public static Response createuser(User payload) {
       String post_url=getURL().getString("post_url");
        Response response;
        response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;


    }
    public static Response readuser(String userName) {
       String get_url=getURL().getString("get_url");
        Response response=(Response) given()
                .pathParam("username", userName)
                .when()
                .get(get_url);
        return response;
    }
    public static Response updateuser(String userName,User payload) {
        String update_url=getURL().getString("update_url");
        Response response=(Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(update_url);
        return response;
    }
    public static Response deleteuser(String userName) {
        String delete_url=getURL().getString("delete_url");
        Response response=(Response) given()
                .pathParam("username", userName)
                .when()
                .delete(delete_url);
        return response;
    }
}


