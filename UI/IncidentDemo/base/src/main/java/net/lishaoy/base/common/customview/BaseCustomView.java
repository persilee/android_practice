package net.lishaoy.base.common.customview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseCustomView<T extends ViewDataBinding, S extends BaseCustomViewModel> extends LinearLayout implements ICustomView<S>, View.OnClickListener {

    private T dataBinding;
    private S viewModel;
    private ICustomViewListener listener;


    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public View getRootView() {
        return dataBinding.getRoot();
    }

    public void init() {

        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (setViewLayoutId() != 0) {
            dataBinding = DataBindingUtil.inflate(inflater, setViewLayoutId(), this, false);
            dataBinding.getRoot().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onAction(ICustomViewListener.ROOT_VIEW_CLICKED, v, viewModel);
                    }
                    onRootClick(v);
                }
            });
        }

    }

    @Override
    public void setData(S data) {
        viewModel = data;
        setDataToView(viewModel);
        if (dataBinding != null) {
            dataBinding.executePendingBindings();
        }
        onDataUpdated();
    }

    protected void onDataUpdated() {}

    @Override
    public void onClick(View v) {

    }

    protected T getDataBinding() {
        return dataBinding;
    }

    protected S getViewModel() {
        return viewModel;
    }

    protected abstract  int setViewLayoutId();

    protected abstract void setDataToView(S data);

    protected abstract void onRootClick(View view);
}
