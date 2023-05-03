package com.example.pokee.phone_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pokee.R;
import com.example.pokee.create_acc_fragments.FirstName;
import com.example.pokee.create_acc_fragments.LastName;

public class PhoneVerification extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_phone_verification, container, false);
        TextView otp_verifying = view.findViewById(R.id.otp_verifying);

        otp_verifying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new FirstName());
                fr.addToBackStack(null);
                fr.commit();

            }
        });
        return view;
    }
}