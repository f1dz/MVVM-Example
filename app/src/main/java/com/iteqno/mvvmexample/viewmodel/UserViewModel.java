package com.iteqno.mvvmexample.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.iteqno.mvvmexample.model.User;

public class UserViewModel {

    public final static String TOAST_MESSAGE_SUCCESS = "Login Success";
    public final static String TOAST_MESSAGE_FAILED = "Login Failed";
    private Context context;
    private User user;

    public UserViewModel(Context context, User user){
        this.user = user;
        this.context = context;
    }

    public void updateModel(String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
    }

    public void validLogin() {

        boolean isValid = false;

        if (TextUtils.isEmpty(user.getEmail()))
            isValid = false;

        if (TextUtils.isEmpty(user.getPassword()))
            isValid = false;

        if (isValid)
            showToast(TOAST_MESSAGE_FAILED);
        else
            showToast(TOAST_MESSAGE_SUCCESS);
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }



}
