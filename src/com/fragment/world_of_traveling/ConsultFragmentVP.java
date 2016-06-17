package com.fragment.world_of_traveling;

import java.util.ArrayList;
import java.util.List;

import com.app.world_of_traveling.R;
import com.fragment.consult.ConsultFragment_question;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ConsultFragmentVP extends Fragment implements OnClickListener {
	private View view;
	private TextView mQuestitm_00;
	private TextView mQuestitm_01;
	private TextView mQuestitm_02;
	private TextView mQuestitm_03;
	private TextView mQuestitm_04;

	private List<Fragment> mFragments;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.tabs_fragment_consult, container, false);
		initView();
		initEvent();
		return view;
	}

	private void initEvent() {
		mQuestitm_00.setOnClickListener(this);
		mQuestitm_01.setOnClickListener(this);
		mQuestitm_02.setOnClickListener(this);
		mQuestitm_03.setOnClickListener(this);
		mQuestitm_04.setOnClickListener(this);

	}

	// 初始化控件
	private void initView() {
		mQuestitm_00 = (TextView) view.findViewById(R.id.consult_text1);
		mQuestitm_01 = (TextView) view.findViewById(R.id.consult_text2);
		mQuestitm_02 = (TextView) view.findViewById(R.id.consult_text3);
		mQuestitm_03 = (TextView) view.findViewById(R.id.consult_text4);
		mQuestitm_04 = (TextView) view.findViewById(R.id.consult_text5);

		// Fragment视图加载绑定
		mFragments = new ArrayList<Fragment>();
		Fragment mQuestion = new ConsultFragment_question();
		Fragment mMore = new ConsultFragment_question();
		mFragments.add(mQuestion);
		mFragments.add(mMore);
	}
//Fragment切换操作
	public void editFragment(){
		//获取fragment的实例
		        Fragment fragment=new Fragment();
		          //获取Fragment的管理器
		          FragmentManager fragmentManager=getFragmentManager();
		          //开启fragment的事物,在这个对象里进行fragment的增删替换等操作。
		          FragmentTransaction ft=fragmentManager.beginTransaction();

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.consult_text1:
			break;
		case R.id.consult_text2:

			break;

		case R.id.consult_text3:

			break;

		case R.id.consult_text4:

			break;

		case R.id.consult_text5:

			break;

		default:
			break;
		}

	}

}
