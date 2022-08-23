package com.example.lesson2_month3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {
    private Button buttonClick;
    private EditText editText;
    public static final String KEY_FOR_BUNDLE = "key";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonClick=view.findViewById(R.id.btn_click);
        editText = view.findViewById(R.id.edt_txt);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().isEmpty()){
                    openSecondFragment();
                }else {
                    editText.setError("Введите значение!");
                }
            }
        });
    }

    private void openSecondFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_BUNDLE, editText.getText().toString());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.
                frame_layout_container, secondFragment).addToBackStack("").commit();

    }
}