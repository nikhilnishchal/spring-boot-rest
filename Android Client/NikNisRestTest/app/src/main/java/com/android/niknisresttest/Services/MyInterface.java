package com.android.niknisresttest.Services;

public interface MyInterface {

    // for login
    void register();
  //  void login(String name, String email, String created_at);
  void login(String token);
    void logout();
}
