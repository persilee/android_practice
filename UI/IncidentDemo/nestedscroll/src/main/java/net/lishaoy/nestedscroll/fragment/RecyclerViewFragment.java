package net.lishaoy.nestedscroll.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.nestedscroll.R;
import net.lishaoy.nestedscroll.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getData(), getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private static final int LOAD_MORE = 3;
            private boolean hasLoadMore;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    hasLoadMore = false;
                }

                if (newState != RecyclerView.SCROLL_STATE_DRAGGING && !hasLoadMore) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int itemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    int offset = recyclerView.getAdapter().getItemCount() - itemPosition - 1;
                    if (offset <= LOAD_MORE) {
                        hasLoadMore = true;
                        recyclerAdapter.data.addAll(getData());
                        recyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });


        return view;
    }

    private int i = 0;

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int temp = i; i < temp + 16; i++) {
            list.add("item " + i);
        }

        return list;
    }
}
