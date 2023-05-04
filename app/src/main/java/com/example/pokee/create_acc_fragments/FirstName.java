package com.example.pokee.create_acc_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokee.MainActivity;
import com.example.pokee.R;
import com.example.pokee.UserActivity;

public class FirstName extends Fragment {

    View view;
    MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first_name, container, false);
        activity = (MainActivity) getActivity();

        Button next_btn = view.findViewById(R.id.next_btn1);
        EditText editText = view.findViewById(R.id.first_name);

        editText.requestFocus();
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            activity.showKeyboard();
        }, 300);

        next_btn.setOnClickListener(v -> {
            activity.hideKeyboard(editText);
            if (!editText.getText().toString().isEmpty()) {


//                Bundle bundle = this.getArguments();
                Bundle bundle = new Bundle();
                bundle.putString("first_name",editText.getText().toString()); // Put anything what you want

                LastName fragment2 = new LastName();
                fragment2.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment2);
                fragmentTransaction.commit();


            } else {
                editText.setError("blank field");
            }

        });
        return view;
    }
}