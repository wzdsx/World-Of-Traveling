package com.app.ui;

import java.util.ArrayList;
import java.util.List;

import com.app.world_of_traveling.R;
import com.app.world_of_traveling.R.color;
import com.fragment.world_of_traveling.ConsultFragmentVP;
import com.fragment.world_of_traveling.FindFragmentVP;
import com.fragment.world_of_traveling.HomeFragmentVP;
import com.fragment.world_of_traveling.LocalFragmentVP;
import com.fragment.world_of_traveling.MineFragmentVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 程序主配置
 * 
 */
public class MainActivity extends FragmentActivity implements OnClickListener {
	// 声明配件
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments;
	// 声明布局文件
	private LinearLayout mTabHome;
	private LinearLayout mTabConsult;
	private LinearLayout mTabLocal;
	private LinearLayout mTabFind;
	private LinearLayout mTabMine;
	// 声明图片控件
	private ImageButton mImgHome;
	private ImageButton mImgConsult;
	private ImageButton mImgLocal;
	private ImageButton mImgFind;
	private ImageButton mImgMine;
	// 声明文字控件
	private TextView mTextHome;
	private TextView mTextConsult;
	private TextView mTextLocal;
	private TextView mTextFind;
	private TextView mTextMine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// 初始化控件
		initView();
		// 初始化点击监听
		initEvent();

	}

	// 初始化点击监听
	private void initEvent() {
		mTabHome.setOnClickListener(this);
		mTabConsult.setOnClickListener(this);
		mTabLocal.setOnClickListener(this);
		mTabFind.setOnClickListener(this);
		mTabMine.setOnClickListener(this);

	}

	// 初始化控件
	private void initView() {
		// ViewPager组件
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		// 视图组件
		mTabHome = (LinearLayout) findViewById(R.id.tab_layout_00);
		mTabConsult = (LinearLayout) findViewById(R.id.tab_layout_01);
		mTabLocal = (LinearLayout) findViewById(R.id.tab_layout_02);
		mTabFind = (LinearLayout) findViewById(R.id.tab_layout_03);
		mTabMine = (LinearLayout) findViewById(R.id.tab_layout_04);
		// 图片按钮组件
		mImgHome = (ImageButton) findViewById(R.id.tab_btn_00);
		mImgConsult = (ImageButton) findViewById(R.id.tab_btn_01);
		mImgLocal = (ImageButton) findViewById(R.id.tab_btn_02);
		mImgFind = (ImageButton) findViewById(R.id.tab_btn_03);
		mImgMine = (ImageButton) findViewById(R.id.tab_btn_04);
		// 文字控件绑定
		mTextHome = (TextView) findViewById(R.id.tab_text_00);
		mTextConsult = (TextView) findViewById(R.id.tab_text_01);
		mTextLocal = (TextView) findViewById(R.id.tab_text_02);
		mTextFind = (TextView) findViewById(R.id.tab_text_03);
		mTextMine = (TextView) findViewById(R.id.tab_text_04);
		// Fragment视图加载绑定
		mFragments = new ArrayList<Fragment>();
		Fragment mTab01 = new HomeFragmentVP();
		Fragment mTab02 = new ConsultFragmentVP();
		Fragment mTab03 = new LocalFragmentVP();
		Fragment mTab04 = new FindFragmentVP();
		Fragment mTab05 = new MineFragmentVP();
		mFragments.add(mTab01);
		mFragments.add(mTab02);
		mFragments.add(mTab03);
		mFragments.add(mTab04);
		mFragments.add(mTab05);
		// 适配器配置
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			// 加载Fragment个数
			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
			}
		};
		// 适配器加载
		mViewPager.setAdapter(mAdapter);

		// 设置滑动监听
		mViewPager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				setTab(currentItem);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	// 点击Tab导航选择
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_layout_00:
			setSelect(0);
			break;
		case R.id.tab_layout_01:
			setSelect(1);
			break;
		case R.id.tab_layout_02:
			setSelect(2);
			break;
		case R.id.tab_layout_03:
			setSelect(3);
			break;
		case R.id.tab_layout_04:
			setSelect(4);
			break;

		default:
			break;
		}

	}

	// 设置Tab选择
	private void setSelect(int i) {
		setTab(i);
		mViewPager.setCurrentItem(i);
	}

	// 设置导航动作
	private void setTab(int i) {
		resetImgs();
		// 设置图片为亮色
		// 切换内容区域
		switch (i) {
		case 0:
			mImgHome.setImageResource(R.drawable.appicon_tabs_home_pressed);
			mTextHome.setTextColor(color.action_bar);
			break;
		case 1:
			mImgConsult.setImageResource(R.drawable.appicon_tabs_consult_pressed);
			mTextConsult.setTextColor(color.action_bar);
			break;
		case 2:
			mImgLocal.setImageResource(R.drawable.appicon_tabs_local_pressed);
			mTextLocal.setTextColor(color.action_bar);
			break;
		case 3:
			mImgFind.setImageResource(R.drawable.appicon_tabs_find_pressed);
			mTextFind.setTextColor(color.action_bar);
			break;
		case 4:
			mImgMine.setImageResource(R.drawable.appicon_tabs_mine_pressed);
			mTextMine.setTextColor(color.action_bar);
			break;
		}
		
	}

	/**
	 * 切换图片至暗色
	 */
	private void resetImgs() {
		mImgHome.setImageResource(R.drawable.appicon_tabs_home);
		mImgConsult.setImageResource(R.drawable.appicon_tabs_consult);
		mImgLocal.setImageResource(R.drawable.appicon_tabs_local);
		mImgFind.setImageResource(R.drawable.appicon_tabs_find);
		mImgMine.setImageResource(R.drawable.appicon_tabs_mine);

	}

}
