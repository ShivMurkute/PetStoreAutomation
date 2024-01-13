package api.endpoints;
/*Swagger URL:https://petstore.swagger.io
	Create user(POST):https://petstore.swagger.io/v2/user
	Get user(get):https://petstore.swagger.io/v2/user/{username}
	Update user(put):https://petstore.swagger.io/v2/user/{username}
	Delete user(delete):https://petstore.swagger.io/v2/user/{username}
	Routes contain url*/
public class Routs {
    public static String base_ulr="https://petstore.swagger.io/v2";

    public static String post_url=base_ulr+"/user";

    public static String get_url=base_ulr+"/user/{username}";

    public static String update_url=base_ulr+"/user/{username}";

    public static String delete_url=base_ulr+"/user/{username}";



}


