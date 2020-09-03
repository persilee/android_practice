package net.lishaoy.nestedscroll.view;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import net.lishaoy.base.common.customview.BaseCustomView;
import net.lishaoy.nestedscroll.R;
import net.lishaoy.nestedscroll.databinding.TitleViewBinding;

public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewModel> {

    public TitleView(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.title_view;
    }

    @Override
    protected void setDataToView(TitleViewModel data) {
        getDataBinding().setViewModel(data);
    }

    @Override
    protected void onRootClick(View view) {
        Toast.makeText(getContext(), "click", Toast.LENGTH_LONG).show();
    }
}
