package getnow.com.retrofit.data.remote.RetrofitClient;

import getnow.com.retrofit.data.model.LoginData;
import getnow.com.retrofit.data.model.Post;
import getnow.com.retrofit.data.model.test;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
//
//    @POST("/posts")
//    @FormUrlEncoded
//    Call<test> savePost(@Field("title") String title,
//                        @Field("body") String body);

//    @POST("Login/checkVendorLogin")
//    Call<Post>checkLogin(@Field("email") String Email,
//                         @Field("password") String Password);
//
//    @POST("Login/checkVendorLogin")
//    @FormUrlEncoded
//    Call<Post> savePost(@Field("email") String title,
//                        @Field("password") String body,
//                        @Field("userId") long userId);
    @POST("Login/checkLogin")
    @FormUrlEncoded
    Call<test>savePost(@Field("email") String Email,
                            @Field("password") String Password);
}
