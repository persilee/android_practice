package net.lishaoy.customrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class GeneralAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private int layoutId;
    private List<T> data;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private ViewGroup viewGroup;

    public GeneralAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (this.viewGroup == null) this.viewGroup = parent;
        return ViewHolder.get(this.context, null, parent, this.layoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        this.setListener(position, holder);
        this.convert(holder, this.data.get(position));
    }

    @Override
    public int getItemCount() {
        return this.data != null ? this.data.size() : 0;
    }

    private void setListener(final int position, final ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GeneralAdapter.this.onItemClickListener != null) {
                    GeneralAdapter.this.onItemClickListener.onItemClick(GeneralAdapter.this.viewGroup, v, GeneralAdapter.this.data.get(position), position);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (GeneralAdapter.this.onItemClickListener != null) {
                    int position = GeneralAdapter.this.getPosition(viewHolder);
                    return GeneralAdapter.this.onItemClickListener.onItemLongClick(GeneralAdapter.this.viewGroup, v, GeneralAdapter.this.data.get(position), position);
                } else {
                    return false;
                }
            }
        });
    }

    private void setListener(final ViewGroup parent, final int position, final ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GeneralAdapter.this.onItemClickListener != null) {
                    int position = GeneralAdapter.this.getPosition(viewHolder);
                    GeneralAdapter.this.onItemClickListener.onItemClick(parent, v, GeneralAdapter.this.data.get(position), position);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (GeneralAdapter.this.onItemClickListener != null) {
                    int position = GeneralAdapter.this.getPosition(viewHolder);
                    return GeneralAdapter.this.onItemClickListener.onItemLongClick(parent, v, GeneralAdapter.this.data.get(position), position);
                } else {
                    return false;
                }
            }
        });
    }

    private int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    public abstract void convert(ViewHolder var1, T var2);

}
