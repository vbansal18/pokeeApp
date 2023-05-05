package com.example.pokee;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.pokee.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserActivity extends AppCompatActivity {
    TextView user_name_text_view;
    TextView user_id_text_view;
    ImageView user_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle bundle = getIntent().getExtras();

        Log.d("BUNDLE", bundle.getString("user_name"));
        user_name_text_view = findViewById(R.id.user_name);
        user_id_text_view = findViewById(R.id.user_id);
        user_image = findViewById(R.id.user_image);

//        Log.d("gfgf", bundle.getString("first_name"));
//        Log.d("gfgf", bundle.getString("last_name"));
//        Log.d("gfgf", bundle.getString("user_name"));
//        Log.d("gfgf", bundle.getString("phone_number"));
//        Log.d("gfgf", bundle.getString("id"));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://user-service.pokee.app/v1/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService requestUser = retrofit.create(RetrofitService.class);

        requestUser.getUser(bundle.getString("id")).enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d("RETROFIT", response.body().getDisplay_name());
                user_name_text_view.setText(response.body().getDisplay_name());
                user_id_text_view.setText(response.body().getUser_name());
                Glide.with(getApplicationContext()).load(response.body().getPhoto_url()).into(user_image);

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("RETROFIT", t.getMessage());
            }
        });


    }

    //    String first_name = getIntent().getStringExtra("first_name");
//    String last_name = getIntent().getStringExtra("last_name");
//    String user_name = getIntent().getStringExtra("user_name");

}

