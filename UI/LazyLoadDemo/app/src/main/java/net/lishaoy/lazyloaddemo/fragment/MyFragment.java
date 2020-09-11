package net.lishaoy.lazyloaddemo.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.lishaoy.lazyloaddemo.R;
import net.lishaoy.lazyloaddemo.adapter.BaseFragment;

public class MyFragment extends BaseFragment {

    private static final String TAG = "MyFragment";
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public MyFragment() {
        // Required empty public constructor
    }

    public static MyFragment newInstance(String param1) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        Log.i(TAG, "onCreate: " + mParam1);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        mParam1 = getArguments().getString(ARG_PARAM1);
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: " + mParam1);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my;
    }

    @Override
    protected void getView(View view) {
        TextView textView = view.findViewById(R.id.text);
        textView.setText(mParam1);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: " + mParam1);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: " + mParam1);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: " + mParam1);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: " + mParam1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + mParam1);
    }
}