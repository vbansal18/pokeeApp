package com.example.pokee.create_acc_fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokee.MainActivity;
import com.example.pokee.R;
import com.example.pokee.UserActivity;
import com.example.pokee.databinding.FragmentFirstNameBinding;
import com.example.pokee.databinding.FragmentPhoneNumBinding;

public class FirstName extends Fragment {
    private FragmentFirstNameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstNameBinding.inflate(inflater, container, false);
        MainActivity activity = (MainActivity) getActivity();

        binding.firstName.requestFocus();
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            activity.showKeyboard();
        }, 300);

        binding.firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(binding.firstName.getText().toString())) {
                    binding.firstName.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,239,108,0)));
                    binding.nextBtn1.setBackgroundColor(Color.argb(100,239,108,0));// set here your backgournd to button
                }
                else{
                    binding.firstName.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,136,136,136)));
                    binding.nextBtn1.setBackgroundColor(Color.argb(100,136,136,136));// set here your backgournd to button
                }
            }
        });

        binding.nextBtn1.setOnClickListener(v -> {
            activity.hideKeyboard(binding.firstName);
            if (!binding.firstName.getText().toString().isEmpty()) {


                Bundle bundle = this.getArguments();
//                Bundle bundle = new Bundle();
                bundle.putString("first_name",binding.firstName.getText().toString()); // Put anything what you want

                LastName fragment2 = new LastName();
                fragment2.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment2);
                fragmentTransaction.commit();


            } else {
                binding.firstName.setError("blank field");
            }

        });
        return binding.getRoot();
    }
}