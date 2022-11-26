package com.example.usermanagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.usermanagement.ModelResponse.User;

public class SharedPrefManager {

    private static String SHARED_PREF_NAME = "jeev";
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    public void SaveUser(User user) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("id",user.getId());
        editor.putString("uname", user.getUname());
        editor.putString("email", user.getEmail());
        editor.putBoolean("logged", true);
        editor.apply();
    }

    public boolean isLoggedIn(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);
    }

    public User getUser() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        return new User(sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("uname", null),
                sharedPreferences.getString("email", null));
    }

    public void Logout(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}