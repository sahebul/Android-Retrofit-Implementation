package getnow.com.retrofit.data.remote.RetrofitClient;

public class ApiUtils {

    private ApiUtils() {}

//    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static final String BASE_URL = "http://10.0.2.2/homergize-website/backend_api/v1/";
    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
