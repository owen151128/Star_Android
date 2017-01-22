package kr.pe.dreamer.startalk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rhdlr on 2017-01-22.
 */

public class FriendFragment extends Fragment {
    public static FriendFragment newInstance() {
        FriendFragment friendFragment = new FriendFragment();

        return friendFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new FriendRecylerAdpater());

        return view;
    }


    private class FriendRecylerAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
            return new FriendFragment.FriendViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((FriendFragment.FriendViewHolder) holder).setItem();
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    private class FriendViewHolder extends RecyclerView.ViewHolder {

        public FriendViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem() {

        }
    }
}
