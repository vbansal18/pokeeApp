package com.example.pokee.create_acc_fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.pokee.MainActivity;
import com.example.pokee.R;
import com.example.pokee.RetrofitService;
import com.example.pokee.UserActivity;
import com.example.pokee.databinding.FragmentLastNameBinding;
import com.example.pokee.databinding.FragmentUserNameBinding;
import com.example.pokee.model.UserBody;
import com.example.pokee.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserName extends Fragment {
    View view;
    MainActivity activity;
//    Bundle arguments = getArguments();
//    String first_name = arguments.getString("first_name");
//    String last_name = arguments.getString("last_name");
    private FragmentUserNameBinding binding;

    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_name, container, false);
        binding = FragmentUserNameBinding.inflate(inflater, container, false);
        activity = (MainActivity) getActivity();

        Button next_btn = view.findViewById(R.id.next_btn3);

        EditText editText = view.findViewById(R.id.username);
        editText.requestFocus();
        handler = new Handler();
//        handler.postDelayed(() -> {
//            ((MainActivity) getActivity()).showKeyboard();
//        }, 300);
        binding.username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(binding.username.getText().toString())) {
                    binding.username.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,239,108,0)));
                    binding.nextBtn3.setBackgroundColor(Color.argb(100,239,108,0));// set here your backgournd to button
                }
                else{
                    binding.username.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,136,136,136)));
                    binding.nextBtn3.setBackgroundColor(Color.argb(100,136,136,136));// set here your backgournd to button
                }
            }
        });


        next_btn.setOnClickListener(v -> {
            activity.hideKeyboard(editText);
            if (!editText.getText().toString().isEmpty()) {
                bundle.putString("user_name", editText.getText().toString()); // Put anything what you want


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://user-service.pokee.app/v1/user/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                RetrofitService requestUser = retrofit.create(RetrofitService.class);

                Log.d("FFFF", bundle.getString("first_name"));

                requestUser.postUser(new UserBody(
                        bundle.getString("id"),
                        bundle.getString("first_name"),
                        bundle.getString("last_name"),
                        bundle.getString("user_name"),
                        bundle.getString("phone_number")
//                        "dlfkj4589sdjhhl",
//                        "Vaibhav",
//                        "Bansal",
//                        "bansu1001",
//                        "+918388908302"
                )).enqueue(new Callback<UserResponse>() {

                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Log.d("RETROFIT", String.valueOf(response.code()));
                        Intent myIntent = new Intent(getContext(), UserActivity.class);
                        myIntent.putExtras(bundle);
                        getActivity().startActivity(myIntent);
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Log.d("RETROFIT", t.getMessage());
                        Toast.makeText(getContext(), "Error occured: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                editText.setError("blank field");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(() -> ((MainActivity) getActivity()).showKeyboard(), 300);
    }
}