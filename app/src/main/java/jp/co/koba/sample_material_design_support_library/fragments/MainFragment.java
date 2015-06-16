package jp.co.koba.sample_material_design_support_library.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.koba.sample_material_design_support_library.R;

public class MainFragment extends Fragment {
    private View view;

    @InjectView(R.id.text_input_layout_1)
    TextInputLayout textInputLayout1;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textInputLayout1.setErrorEnabled(true);
        textInputLayout1.setError(getString(R.string.error_message));
    }
}
