package com.example.pokee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pokee.phone_fragments.PhoneNumFragment;

public class FirstScreenFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first_screen, container, false);

        Button create_account_btn = view.findViewById(R.id.create_acc_btn);

        create_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout,new PhoneNumFragment());
                fr.addToBackStack(null);
                fr.commit();

            }
        });

        return view;
    }
}