package com.example.pokee.phone_fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokee.MainActivity;
import com.example.pokee.R;
import com.example.pokee.create_acc_fragments.FirstName;
import com.example.pokee.create_acc_fragments.LastName;
import com.example.pokee.databinding.FragmentPhoneNumBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.ktx.Firebase;

import java.util.concurrent.TimeUnit;

public class PhoneNumFragment extends Fragment {
    private FragmentPhoneNumBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPhoneNumBinding.inflate(inflater, container, false);
        MainActivity activity = (MainActivity) getActivity();


        binding.nextBtn.setOnClickListener(v -> {
            if(binding.phoneNumber.getText().toString().length()!=10){
                ((Button) v).setBackgroundColor(Color.RED);


                Log.d("PHONE", binding.phoneNumber.getText().toString());
                binding.phoneNumber.setError("invalid phone");
            }
            else{

                activity.otpSend(binding.phoneNumber.getText().toString().trim());



            }
        });

        return binding.getRoot();
    }


}