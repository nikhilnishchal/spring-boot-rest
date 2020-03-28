package com.android.niknisresttest.Services;

import com.android.niknisresttest.Model.UserAuth;
import com.android.niknisresttest.Model.UserRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceApi {

    @POST("/user/sign-up")
    Call<Void> doRegistration(@Body UserRegister user);

    /*@GET("/login")
    Call<User> doLogin(@("email") String email, @Query("password") String password);
*/
    @POST("/login")
    public Call<Void> doLogin(@Body UserAuth user);
}
