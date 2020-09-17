package net.lishaoy.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import net.lishaoy.base.loadsir.ErrorCallback;
import net.lishaoy.base.loadsir.LoadingCallback;
import net.lishaoy.webview.databinding.FragmentWebviewBinding;
import net.lishaoy.webview.utils.Constants;
import net.lishaoy.webview.webChromeClient.CustomWebChromeClient;
import net.lishaoy.webview.webviewclient.CustomWebViewClient;

public class WebViewFragment extends Fragment implements OnRefreshListener, WebViewCallBack {

    private static final String TAG = "WebViewFragment";
    private FragmentWebviewBinding binding;
    private String url;
    private boolean canRefresh;
    private LoadService loadService;
    private boolean isError = false;

    public static WebViewFragment newInstance(String url, boolean canRefresh) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.URL, url);
        bundle.putBoolean(Constants.CAN_REFRESH, canRefresh);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            url = bundle.getString(Constants.URL);
            canRefresh = bundle.getBoolean(Constants.CAN_REFRESH);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_webview, container, false);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl(url);
        loadService = LoadSir.getDefault().register(binding.webviewRefresh, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showCallback(LoadingCallback.class);
                binding.webview.reload();
            }
        });
        binding.webview.setWebViewClient(new CustomWebViewClient(this));
        binding.webview.setWebChromeClient(new CustomWebChromeClient(this));
        binding.webviewRefresh.setRefreshHeader(new ClassicsHeader(getContext()));
        binding.webviewRefresh.setOnRefreshListener(this);
        binding.webviewRefresh.setEnableRefresh(canRefresh);
        binding.webviewRefresh.setEnableLoadMore(false);

        return loadService.getLoadLayout();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        binding.webview.reload();
    }

    @Override
    public void pageStarted(String url) {
        if (loadService != null) {
            loadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void pageFinished(String url) {
        if (isError) {
            binding.webviewRefresh.setEnableRefresh(true);
        } else {
            binding.webviewRefresh.setEnableRefresh(canRefresh);
        }
        binding.webviewRefresh.finishRefresh();
        if (loadService != null && isError) {
            loadService.showCallback(ErrorCallback.class);
        } else {
            loadService.showSuccess();
        }
        isError = false;
    }

    @Override
    public void onError() {
        isError = true;
        binding.webviewRefresh.finishRefresh();
    }

    @Override
    public void updateTitle(String title) {
        if (getActivity() instanceof WebViewActivity){
            ((WebViewActivity)getActivity()).updateTitle(title);
        }
    }
}
