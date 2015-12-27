package com.allen.tabhostdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.allen.tabhostdemo.bean.Tab;
import com.allen.tabhostdemo.fragment.CartFragment;
import com.allen.tabhostdemo.fragment.CategoryFragment;
import com.allen.tabhostdemo.fragment.FindFragment;
import com.allen.tabhostdemo.fragment.HomeFragment;
import com.allen.tabhostdemo.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 15/12/27.
 */
public class MyTabHostActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;

    private List<Tab> tabs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        initTab();
    }

    /**
     * 初始换tabhost
     */
    private void initTab() {
        //把需要用到的title    icon    fragment封装到tabbean对象
        Tab home = new Tab(R.string.home, R.drawable.home_btn_selector, HomeFragment.class);
        Tab find = new Tab(R.string.find, R.drawable.faxian_btn_selector, FindFragment.class);
        Tab cart = new Tab(R.string.cart, R.drawable.cart_btn_selector, CartFragment.class);
        Tab category = new Tab(R.string.category, R.drawable.category_btn_selector, CategoryFragment.class);
        Tab mine = new Tab(R.string.mine, R.drawable.mine_btn_selector, MineFragment.class);
        tabs.add(home);
        tabs.add(find);
        tabs.add(cart);
        tabs.add(category);
        tabs.add(mine);

        mInflater = LayoutInflater.from(this);
        //获取FragmentTabHost对象
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        //设置setup方法
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //取消默认的Tab间的竖线显示
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //设置默认选中第一个
        mTabHost.setCurrentTab(0);

        //循环把自定义的tab添加上去
        for (Tab tab : tabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

    }

    /**
     * 构建Indicator
     * @param tab
     * @return
     */
    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_item, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon_iv);
        TextView title = (TextView) view.findViewById(R.id.title_tv);

        icon.setBackgroundResource(tab.getIcon());
        title.setText(tab.getTitle());

        return view;
    }
}
