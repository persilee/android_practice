package net.lishaoy.materialdesigndemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.materialdesigndemo.R;
import net.lishaoy.materialdesigndemo.bean.NavListItem;

import java.util.List;

public class NavRecyclerViewAdapter extends RecyclerView.Adapter<NavRecyclerViewAdapter.NavViewHolder> {

    private static final String TAG = "NavRecyclerViewAdapter";
    private Context context;
    private List<NavListItem> navListItems;

    public NavRecyclerViewAdapter(Context context, List<NavListItem> navListItems) {
        this.context = context;
        this.navListItems = navListItems;
    }

    @NonNull
    @Override
    public NavRecyclerViewAdapter.NavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NavViewHolder(LayoutInflater.from(context).inflate(R.layout.nav_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NavRecyclerViewAdapter.NavViewHolder holder, final int position) {
        holder.imageView.setImageResource(navListItems.get(position).getIcon());
        holder.textView.setText(navListItems.get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, navListItems.get(position).getActivity());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return navListItems.size();
    }

    public class NavViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public NavViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.icon);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
