package api.test;

import api.endpoints.Endpoints;
import api.endpoints.Endpoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserTest2 {

    Faker faker;
    User userpayload;

    public Logger logger;
    @BeforeClass
    public void setupdata(){//Set up data using pojo
        faker=new Faker();
        userpayload=new User();

        userpayload.setId(faker.idNumber().hashCode());;
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password(3,4));
        userpayload.setPhone(faker.phoneNumber().cellPhone());
//logs
        logger= (Logger) LogManager.getLogger(this.getClass());


    }
    @Test(priority = 1)

    public void testCreateuser() {
        logger.info("******Creating User******");
        Response response= Endpoints2.createuser(userpayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******Created user******");

    }
    @Test(priority=2)
    public void testReaduser() {
        logger.info("******Reading user******");
        Response response=(Response) Endpoints2.readuser(this.userpayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******User displayed ******");
    }
    @Test(priority = 3)
    public void testUpdateuser(){
        //update details usinf payload
        logger.info("******Updating user******");
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());

        Response response=Endpoints2.updateuser(this.userpayload.getUsername(),userpayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******User update successfully******");
        //check  updated data

        Response responseAfterupdate=Endpoints2.createuser(userpayload);
        Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
    }
    @Test(priority = 4)

    void testdeleteuserbyName(){
        logger.info("******Deleting user******");
        Response response=Endpoints2.deleteuser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******User deleted******");
    }
}
