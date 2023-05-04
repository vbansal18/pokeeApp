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

public class UserName extends Fragment {
    View view;
    MainActivity activity;
//    Bundle arguments = getArguments();
//    String first_name = arguments.getString("first_name");
//    String last_name = arguments.getString("last_name");

    Handler handler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_name, container, false);
        activity = (MainActivity) getActivity();

        Button next_btn = view.findViewById(R.id.next_btn3);

        EditText editText = view.findViewById(R.id.username);
        editText.requestFocus();
        handler = new Handler();
//        handler.postDelayed(() -> {
//            ((MainActivity) getActivity()).showKeyboard();
//        }, 300);


        next_btn.setOnClickListener(v -> {
            activity.hideKeyboard(editText);
            if (!editText.getText().toString().isEmpty()) {

                Intent myIntent = new Intent(getActivity().getBaseContext(), UserActivity.class);
                getActivity().startActivity(myIntent);



            }else {
                editText.setError("blank field");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(() -> ((MainActivity) getActivity()).showKeyboard(), 300);
    }
}