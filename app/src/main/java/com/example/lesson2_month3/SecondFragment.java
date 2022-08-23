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

public class SecondFragment extends Fragment {
    private EditText editText;
    private Button buttonClick;
    public static final String KEY_FOR_BUNDLE = "key 1";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonClick = view.findViewById(R.id.btn_click_in_second_fragment);
        editText = view.findViewById(R.id.edt_txt_in_second_fragment);
        assert getArguments() != null;
        String value = getArguments().getString(FirstFragment.KEY_FOR_BUNDLE);
            editText.setText(value);


        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().isEmpty()){
                    openThirdFragment();
                }else {
                    editText.setError("Введите значение!");
                }
            }
        });

    }

    private void openThirdFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_BUNDLE, editText.getText().toString());
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.
                frame_layout_container, thirdFragment).addToBackStack("").commit();
    }

}