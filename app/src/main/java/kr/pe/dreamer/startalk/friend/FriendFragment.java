package kr.pe.dreamer.startalk.friend;

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
import kr.pe.dreamer.startalk.profile.ProfileActivity;
import kr.pe.dreamer.startalk.util.ImageLoad;

/**
 * Created by rhdlr on 2017-01-22.
 */

public class FriendFragment extends Fragment {
    private FriendModel model;
    private RecyclerView recyclerView;

    public static FriendFragment newInstance() {
        FriendFragment friendFragment = new FriendFragment();

        return friendFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new FriendRecylerAdpater());

        model = new FriendModel();

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
            ((FriendFragment.FriendViewHolder) holder).setItem(model.getItem(position));
        }

        @Override
        public int getItemCount() {
            return model.getCount();
        }
    }

    private class FriendViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_message;
        private ImageView iv_profile;

        public FriendViewHolder(View view) {
            super(view);

            tv_name = (TextView) view.findViewById(R.id.tv_friend_name);
            tv_message = (TextView) view.findViewById(R.id.tv_friend_message);
            iv_profile = (ImageView) view.findViewById(R.id.iv_profile_photo);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = recyclerView.getChildLayoutPosition(view);
                    FriendModel.Item item = model.getItem(position);

                    Intent intent = new ProfileActivity.Builder(getContext())
                            .setName(item.getName())
                            .setId(item.getId())
                            .build();

                    startActivity(intent);
                }
            });
        }

        public void setItem(FriendModel.Item item) {
            tv_name.setText(item.getName());
            tv_message.setText(item.getMessage());
            ImageLoad.getInstance().circleLoad(getContext(), iv_profile, R.drawable.thm_general_default_profile_image);
        }
    }
}
