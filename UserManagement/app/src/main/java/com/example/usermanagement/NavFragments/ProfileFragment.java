package com.example.usermanagement.NavFragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usermanagement.ModelResponse.UpdateResponse;
import com.example.usermanagement.R;
import com.example.usermanagement.RetrofitClient;
import com.example.usermanagement.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText username, email;
    Button update;
    SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        sharedPrefManager = new SharedPrefManager(getActivity().getApplicationContext());
        int id = sharedPrefManager.getUser().getId();
        username = view.findViewById(R.id.userName);
        email = view.findViewById(R.id.userEmail);
        update = view.findViewById(R.id.btnUpdateAccount);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String useremail = email.getText().toString();

                if (uname.isEmpty()) {
                    username.requestFocus();
                    username.setError("Enter username");
                }

                if (useremail.isEmpty()) {
                    email.requestFocus();
                    email.setError("Enter email");
                }

                Call<UpdateResponse> call = RetrofitClient.getInstance().getapi().update(id,uname,useremail);

                call.enqueue(new Callback<UpdateResponse>() {
                    @Override
                    public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                        UpdateResponse updateResponse = response.body();
                        if (response.isSuccessful()){
                            Toast.makeText(getActivity(), updateResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), updateResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateResponse> call, Throwable t) {

                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



        return  view;
    }
}