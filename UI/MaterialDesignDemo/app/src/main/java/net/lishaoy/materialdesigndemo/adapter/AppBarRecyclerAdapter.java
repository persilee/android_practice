package net.lishaoy.materialdesigndemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

public class AppBarRecyclerAdapter extends RecyclerView.Adapter<AppBarRecyclerAdapter.BottomViewHolder> {

    Context context;
    List<Integer> lists = new ArrayList<>();

    public AppBarRecyclerAdapter(Context context) {
        this.context = context;
        this.lists = getLists();
    }

    @NonNull
    @Override
    public AppBarRecyclerAdapter.BottomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BottomViewHolder(LayoutInflater.from(context).inflate(R.layout.bottom_bar_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppBarRecyclerAdapter.BottomViewHolder holder, int position) {
        holder.textView.setText(lists.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    private List<Integer> getLists() {
        for (int i = 0; i < 66; i++) {
            lists.add(i);
        }

        return lists;
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bottom_bar_item_text);
        }
    }
}
