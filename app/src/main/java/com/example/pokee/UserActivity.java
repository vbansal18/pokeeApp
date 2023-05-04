package com.example.pokee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokee.model.RequestPost;
import com.example.pokee.model.ResponsePost;
import com.example.pokee.model.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public class UserActivity extends AppCompatActivity {
//    String first_name = getIntent().getStringExtra("first_name");
//    String last_name = getIntent().getStringExtra("last_name");
//    String user_name = getIntent().getStringExtra("user_name");
//    interface RequestUser{
//        @GET("{id}")
//        Call<UserData> getUser(@Path("id") String id);
//
//    }


//    TextView user_name_text_view = findViewById(R.id.user_name);
//    TextView user_id_text_view = findViewById(R.id.user_id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("'user-service.pokee.app/v1/user/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestUser requestUser = retrofit.create(RequestUser.class);
//
//
//
//        requestUser.getUser("dlfkj4589sdjhhl").enqueue(new Callback<UserData>() {
//
//            @Override
//            public void onResponse(Call<UserData> call, Response<UserData> response) {
//                user_name_text_view.setText(response.body().getUser_name());
//                user_id_text_view.setText(response.body().getId());
//            }
//
//            @Override
//            public void onFailure(Call<UserData> call, Throwable t) {
//
//            }
//        });
    }
}

