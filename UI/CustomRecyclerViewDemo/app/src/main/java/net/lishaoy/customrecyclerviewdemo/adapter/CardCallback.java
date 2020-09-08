package net.lishaoy.customrecyclerviewdemo.adapter;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.customrecyclerviewdemo.bean.CardBean;
import net.lishaoy.customrecyclerviewdemo.util.Utils;

import java.util.List;

public class CardCallback extends ItemTouchHelper.SimpleCallback {

    private RecyclerView recyclerView;
    private GeneralAdapter<CardBean> adapter;
    private List<CardBean> beans;

    public CardCallback(RecyclerView recyclerView, GeneralAdapter<CardBean> adapter, List<CardBean> beans) {
        super(0, 15);
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.beans = beans;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        CardBean cardBean = beans.remove(viewHolder.getLayoutPosition());
        beans.add(0, cardBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        double maxDistance = recyclerView.getWidth() * 0.6f;
        double distance = Math.sqrt(dX * dX + dY * dY);
        double fraction = distance / maxDistance;

        if (fraction > 1) fraction = 1;

        int itemCount = recyclerView.getChildCount();

        for (int i = 0; i < itemCount; i++) {
            View view = recyclerView.getChildAt(i);
            int level = itemCount - i - 1;
            if (level > 0 && level < 3){
                view.setTranslationY((float) (Utils.dp2px(16) * level - fraction * 0.06f));
                view.setScaleX((float) (1 - 0.06f * level + fraction * 0.06f));
                view.setScaleX((float) (1 - 0.06f * level + fraction * 0.06f));
                view.setScaleY((float) (1 - 0.06f * level + fraction * 0.06f));
            }
        }

    }
}
