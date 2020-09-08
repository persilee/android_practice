package net.lishaoy.customrecyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.customrecyclerviewdemo.R;
import net.lishaoy.customrecyclerviewdemo.bean.CardBean;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private Context context;
    private List<CardBean> cardBeans;

    public CardAdapter(Context context, List<CardBean> cardBeans) {
        this.context = context;
        this.cardBeans = cardBeans;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.CardViewHolder holder, int position) {
        holder.image.setImageResource(cardBeans.get(position).getResource());
        holder.title.setText(cardBeans.get(position).getName());
        holder.number.setText(cardBeans.get(position).getPosition() + "/" + cardBeans.size());
    }

    @Override
    public int getItemCount() {
        return cardBeans.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final TextView number;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            number = itemView.findViewById(R.id.number);

        }
    }
}
