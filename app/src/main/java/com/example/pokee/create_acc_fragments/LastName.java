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

public class LastName extends Fragment {
    View view;
//    Bundle arguments = getArguments();
//    String first_name = arguments.getString("first_name");

    MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_last_name, container, false);
        activity = (MainActivity) getActivity();
        Button next_btn = view.findViewById(R.id.next_btn2);

        EditText editText = view.findViewById(R.id.last_name);
        editText.requestFocus();

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            ((MainActivity) getActivity()).showKeyboard();
        }, 300);

        next_btn.setOnClickListener(v -> {
            activity.hideKeyboard(editText);
            if (!editText.getText().toString().isEmpty()) {

                UserName fragment2 = new UserName();
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