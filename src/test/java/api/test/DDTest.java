package api.test;

import api.endpoints.Endpoints;
import api.payload.User;
import api.utilitise.DataProvider1;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTest {
    @Test(priority = 1,dataProvider ="Data",dataProviderClass = DataProvider1.class)
    public void testPostUser(String userID,String userName,String Firstname,String Lastname,String email,String password,String phone){
        User userpayload= new User();

        userpayload.setId(Integer.parseInt(userID));
        userpayload.setUsername(userName);
        userpayload.setFirstName(Firstname);
        userpayload.setLastName(Lastname);
        userpayload.setEmail(email);
        userpayload.setPassword(password);
        userpayload.setPhone(phone);

        Response response= Endpoints.createuser(userpayload);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProvider1.class)
    public void testDeleteuser(String userName){
      Response response = Endpoints.deleteuser(userName);
      Assert.assertEquals(response.getStatusCode(),200);
    }

}
