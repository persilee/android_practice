package net.lishaoy.lazyloaddemo.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    private View view;
    private boolean isCreated = false;
    private boolean isVisibleState = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutRes(), container, false);
        }
        getView(view);
        isCreated = true;
        if (getUserVisibleHint()){
            setUserVisibleHint(true);
        }
        return view;
    }

    protected abstract int getLayoutRes();
    protected abstract void getView(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isCreated) {
            if (isVisibleToUser && !isVisibleState) {
                dispatchUserVisibleHint(true);
            }else if(!isVisibleToUser && isVisibleState) {
                dispatchUserVisibleHint(false);
            }
        }
    }

    private void dispatchUserVisibleHint(boolean isVisibleState) {
        this.isVisibleState = isVisibleState;
        if (isVisibleState && isParentVisible()) {
            return;
        }
        if (isVisibleState) {
            onFragmentLoad();
            dispatchChildVisibleState(true);
        }else {
            onFragmentStop();
            dispatchChildVisibleState(false);
        }
    }

    private void dispatchChildVisibleState(boolean state) {
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                    ((BaseFragment) fragment).dispatchUserVisibleHint(state);
                }
            }
        }
    }

    private void onFragmentStop() {
        Log.i(TAG, "onFragmentStop: ");
    }

    protected void onFragmentLoad() {
        Log.i(TAG, "onFragmentLoad: ");
    };

    private boolean isParentVisible() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof BaseFragment) {
            BaseFragment fragment = (BaseFragment) parentFragment;
            return !fragment.isVisibleState;
        }
        return false;
    }
}
