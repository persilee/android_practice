package net.lishaoy.base.common.customview;

import android.view.View;

public interface ICustomViewListener {

    String ROOT_VIEW_CLICKED = "root_view_clicked";

    void onAction(String action, View view, BaseCustomViewModel viewModel);

}
