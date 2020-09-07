package net.lishaoy.customrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.customrecyclerviewdemo.R;
import net.lishaoy.customrecyclerviewdemo.bean.DataBean;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private List<DataBean> beans;

    public RecyclerAdapter(Context context, List<DataBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    public boolean isTitle(int position) {

        if (position == 0) {
            return true;
        } else {
            String group = getGroup(position);
            String preGroup = getGroup(position - 1);
            if (preGroup.equals(group)) {
                return false;
            }else {
                return true;
            }
        }

    }

    public String getGroup(int position){
        return beans.get(position).getGroupText();
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.textView.setText(beans.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
        }
    }
}
