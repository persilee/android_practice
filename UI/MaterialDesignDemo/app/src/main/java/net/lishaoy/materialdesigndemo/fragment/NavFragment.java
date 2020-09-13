package net.lishaoy.materialdesigndemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.lishaoy.materialdesigndemo.R;

public class NavFragment extends Fragment {

    private String s;

    public static NavFragment newFragment(String s) {
        NavFragment navFragment = new NavFragment();
        Bundle bundle = new Bundle();
        bundle.putString("page", s);
        navFragment.setArguments(bundle);
        return navFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            s = getArguments().getString("page");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nav, container, false);
        TextView textView = view.findViewById(R.id.nav_fragment_text);
        textView.setText(s);

        return view;
    }
}
