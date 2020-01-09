package businessll;

import java.io.IOException;

import api.UserApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Url;
import serverresponse.UserResponse;
import url.ApiUrl;

public class LoginBll {

    boolean isSuccess = false;

    public boolean checkUser(String email, String password) {

        UserApi usersAPI = ApiUrl.getInstance().create(UserApi.class);
        Call<UserResponse> usersCall = usersAPI.checkUser(email, password);

        try {
            Response<UserResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                ApiUrl.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

