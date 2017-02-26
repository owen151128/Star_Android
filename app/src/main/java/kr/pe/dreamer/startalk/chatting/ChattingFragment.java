package kr.pe.dreamer.startalk.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kr.pe.dreamer.startalk.R;
import kr.pe.dreamer.startalk.util.ImageLoad;

/**
 * Created by rhdlr on 2017-01-22.
 */

public class ChattingFragment extends Fragment {
    private ChattingModel model;

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

        model = new ChattingModel();
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
            ((ChattingViewHolder)holder).setItem(model.getItem(position));
        }

        @Override
        public int getItemCount() {
            return model.getCount();
        }
    }

    private class ChattingViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_message;
        private TextView tv_time;
        private TextView tv_personnel;
        private TextView tv_number;
        private ImageView iv_room;

        public ChattingViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_chatting_name);
            tv_message = (TextView) view.findViewById(R.id.tv_chtting_message);
            tv_time = (TextView) view.findViewById(R.id.tv_chtting_time);
            tv_personnel = (TextView) view.findViewById(R.id.tv_chatting_personnel);
            tv_number = (TextView) view.findViewById(R.id.tv_message_number);
            iv_room = (ImageView) view.findViewById(R.id.iv_room);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),ChattingActivity.class);
                    startActivity(intent);
                }
            });
        }

        public void setItem(ChattingModel.Item item){
            tv_name.setText(item.getName());
            tv_message.setText(item.getMessage());
            tv_time.setText(item.getTime());
            tv_personnel.setText(String.valueOf(item.getPersonnel()));
            tv_number.setText(String.valueOf(item.getMessageCount()));
            ImageLoad.getInstance().circleLoad(getContext(),iv_room,R.drawable.thm_general_default_profile_image);
        }
    }
}
