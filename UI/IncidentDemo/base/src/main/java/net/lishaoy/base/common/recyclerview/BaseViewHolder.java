package net.lishaoy.base.common.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.base.common.customview.BaseCustomViewModel;
import net.lishaoy.base.common.customview.ICustomView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    ICustomView customView;

    public BaseViewHolder(ICustomView customView) {
        super((View) customView);
        this.customView = customView;
    }

    public BaseViewHolder(@NonNull View itemView, ICustomView customView) {
        super(itemView);
        this.customView = customView;
    }

    public void bind(@NonNull BaseCustomViewModel viewModel) {
        customView.setData(viewModel);
    }
}
