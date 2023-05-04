package com.example.pokee.phone_fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pokee.MainActivity;
import com.example.pokee.databinding.FragmentPhoneVerificationBinding;
import com.example.pokee.util.GenericTextWatcher;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class PhoneVerificationFragment extends Fragment {
    private FragmentPhoneVerificationBinding binding;
    private String verificationId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPhoneVerificationBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            verificationId = bundle.getString("verificationId");
        }

        binding.verificationCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(binding.verificationCode1.getText().toString())) {
                    binding.verificationCode1.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,239,108,0)));
                    binding.verifyBtn.setBackgroundColor(Color.argb(100,239,108,0));// set here your backgournd to button
                }
                else{
                    binding.verificationCode1.setBackgroundTintList(ColorStateList.valueOf(Color.argb(100,136,136,136)));
                    binding.verifyBtn.setBackgroundColor(Color.argb(100,136,136,136));// set here your backgournd to button
                }
            }
        });
        
        binding.verifyBtn.setOnClickListener(v -> {
            String code = binding.verificationCode1.getText().toString() + binding.verificationCode2.getText().toString() + binding.verificationCode3.getText().toString() + binding.verificationCode4.getText().toString() + binding.verificationCode5.getText().toString() + binding.verificationCode6.getText().toString();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

            activity.signInWithPhoneAuthCredential(credential);
        });

        binding.verificationCode1.addTextChangedListener(new GenericTextWatcher(binding.verificationCode2));
        binding.verificationCode2.addTextChangedListener(new GenericTextWatcher(binding.verificationCode3));
        binding.verificationCode3.addTextChangedListener(new GenericTextWatcher(binding.verificationCode4));
        binding.verificationCode4.addTextChangedListener(new GenericTextWatcher(binding.verificationCode5));
        binding.verificationCode5.addTextChangedListener(new GenericTextWatcher(binding.verificationCode6));

        return binding.getRoot();
    }
}