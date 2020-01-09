package api;

import model.UserModel;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import serverresponse.ImageResponse;
import serverresponse.UserResponse;

public interface UserApi {

    @POST("users/SignUp")
    Call<UserResponse> registerUser(@Body UserModel users);


    @FormUrlEncoded
    @POST("users/login")
    Call<UserResponse> checkUser(@Field("email") String email, @Field("password") String password);


    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part imageFile);


    @GET("users/details/me")
    Call<UserModel> getUserDetails(@Header("Authorization")String token);







}
