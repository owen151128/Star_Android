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

public class ChattingFragment extends Fragment {
    public static ChattingFragment newInstance(){
        ChattingFragment chattingFragment = new ChattingFragment();

        return chattingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chattig, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_chatting);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ChattingRecylerAdpater());

        return view;
    }

    private class ChattingRecylerAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chatting,parent,false);
            return new ChattingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ChattingViewHolder)holder).setItem();
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    private class ChattingViewHolder extends RecyclerView.ViewHolder{

        public ChattingViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(){

        }
    }
}
