package net.lishaoy.nestedscroll.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.lishaoy.nestedscroll.R;
import net.lishaoy.nestedscroll.bean.Item;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<Item> items;
    private Context context;

    public ListViewAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.icon);
            viewHolder.text = convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Item item = items.get(position);
        viewHolder.icon.setImageResource(item.getIcon());
        viewHolder.text.setText(item.getText());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), item.getActivity());
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        public ImageView icon;
        public TextView text;
    }
}
