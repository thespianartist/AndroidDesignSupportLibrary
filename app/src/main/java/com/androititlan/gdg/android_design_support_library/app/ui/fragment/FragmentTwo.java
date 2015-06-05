package com.androititlan.gdg.android_design_support_library.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androititlan.gdg.android_design_support_library.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Jhordan on 02/06/15.
 */
public class FragmentTwo extends FragmentBase {

    public static FragmentTwo getInstance() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle extraArguments = new Bundle();
        fragmentTwo.setArguments(extraArguments);
        return fragmentTwo;
    }

    @InjectView(R.id.txt_input_layout_correo) TextInputLayout textInputLayoutCorreo;
    @InjectView(R.id.txt_input_layout_community) TextInputLayout textInputLayoutComunnity;
    @InjectView(R.id.edit_txt_mail) AppCompatEditText editMail;
    @InjectView(R.id.edit_txt_community) AppCompatEditText editCommunity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.inject(this, rootView);
        settingsToolbar(rootView);
        return rootView;
    }

    @OnClick(R.id.button) void pushMe() {
        validation();
    }

    public void validation(){

        if(editMail.getText().toString().isEmpty())
            textInputLayoutCorreo.setError("Campo no debe ser vacio");
        else if(editCommunity.getText().toString().isEmpty()) {
            textInputLayoutComunnity.setError("Campo no debe ser vacio");
            textInputLayoutCorreo.setErrorEnabled(false);
        }
        else if (!validateMail(editMail.getText().toString())) {
            textInputLayoutCorreo.setError("Ese no es un correo electronico!");
            textInputLayoutComunnity.setErrorEnabled(false);
        }else{
            textInputLayoutCorreo.setErrorEnabled(false);
            Toast.makeText(getActivity(), editCommunity.getText().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    public boolean validateMail(String mail) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    @Override
    protected void settingsToolbar(View rootView) {
        super.settingsToolbar(rootView);
    }
}
