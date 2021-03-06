package com.xiaoming.a008project.fenle.home.bottom_tab;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import com.xiaoming.a008project.R;
import com.xiaoming.a008project.fenle.RouterKey;
import com.xiaoming.a008project.fenle.home.HomeActivity;
import com.xiaoming.a008project.fenle.home.header.CommHeader;

import java.util.HashMap;

public class TabController {

    private HomeActivity mHomeActivity;
    private LinearLayout mVHomeTabs;
    private HashMap<String, Integer> mNormalIconMap = new HashMap<>(4);
    private TabClickListener mTabClickListener;

    public TabController(HomeActivity homeActivity, LinearLayout homeTabs) {
        this.mHomeActivity = homeActivity;
        this.mVHomeTabs = homeTabs;

        mNormalIconMap.put(RouterKey.HOME_NEW_SHOPPING_KEY, R.drawable.ic_shopping_normal);
        mNormalIconMap.put(RouterKey.HOME_APP_KEY, R.drawable.ic_app_normal);
        mNormalIconMap.put(RouterKey.HOME_MESSAGE_KEY, R.drawable.ic_message_normal);
        mNormalIconMap.put(RouterKey.HOME_MINE_KEY, R.drawable.ic_mine_normal);
    }

    public void initBottomTab() {
        mVHomeTabs.removeAllViews();

        for(int i=0; i<mNormalIconMap.size();i++) {
            View itemView = LayoutInflater.from(mHomeActivity).inflate(R.layout.item_home_activity_bottom_tab, mVHomeTabs, false);
            ImageView mIvHomeTabImg = itemView.findViewById(R.id.mIvHomeTabImg);
            TextView mTvHomeTabTitle = itemView.findViewById(R.id.mTvHomeTabTitle);
            final int finalI = i;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mTabClickListener != null) {
                        mTabClickListener.onTabClick(finalI, v);
                    }
                }

            });
            mVHomeTabs.addView(itemView);
        }


    }


    public void setTabClickListener(TabClickListener tabClickListener) {
        mTabClickListener = tabClickListener;
    }

    public interface TabClickListener {
        void onTabClick(int index, View v);
    }
}
