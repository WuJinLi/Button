package com.example.my.button;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my.button.fragment.FenleiFragment;
import com.example.my.button.fragment.GengduoFragment;
import com.example.my.button.fragment.ShujiaFragment;
import com.example.my.button.fragment.TuijianFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FenleiFragment fenleiFragment;
    private ShujiaFragment shujiaFragment;
    private TuijianFragment tuijianFragment;
    private GengduoFragment gengduoFragment;
    private FragmentManager manager;
    private Button button_main_tuijian;
    private Button button_main_shujia;
    private Button button_main_fenlei;
    private Button button_main_gengduo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        button_main_tuijian.setSelected(true);
        setSelection(0);

        button_main_tuijian.setOnClickListener(this);
        button_main_shujia.setOnClickListener(this);
        button_main_fenlei.setOnClickListener(this);
        button_main_gengduo.setOnClickListener(this);

    }

    private void initView() {
        button_main_tuijian = (Button) findViewById(R.id.button_main_tuijian);
        button_main_shujia = (Button) findViewById(R.id.button_main_shujia);
        button_main_fenlei = (Button) findViewById(R.id.button_main_fenlei);
        button_main_gengduo = (Button) findViewById(R.id.button_main_gengduo);
        manager = getSupportFragmentManager();
    }

    //自定义方法用于根据对应的按钮下角标，进行响应碎片的展示
    private void setSelection(int tabIndex) {
        //初始化事务，用于处理碎片的显示隐藏
        FragmentTransaction ft = manager.beginTransaction();
        //调用隐藏所有碎片的方法
        hindFragment(ft);
        switch (tabIndex) {
            case 0:
                //判断碎片是否为空，为空进行初始化，创建，不为空，直接显示
                if (tuijianFragment == null) {
                    tuijianFragment = new TuijianFragment();
                    ft.add(R.id.framelayout_main_container, tuijianFragment);
                } else {
                    ft.show(tuijianFragment);
                }
                break;
            case 1:
                if (shujiaFragment == null) {
                    shujiaFragment = new ShujiaFragment();
                    ft.add(R.id.framelayout_main_container, shujiaFragment);
                } else {
                    ft.show(shujiaFragment);
                }
                break;
            case 2:
                if (fenleiFragment == null) {
                    fenleiFragment = new FenleiFragment();
                    ft.add(R.id.framelayout_main_container, fenleiFragment);
                } else {
                    ft.show(fenleiFragment);
                }
                break;
            case 3:
                if (gengduoFragment == null) {
                    gengduoFragment = new GengduoFragment();
                    ft.add(R.id.framelayout_main_container, gengduoFragment);
                } else {
                    ft.show(gengduoFragment);
                }
                break;
        }
        //执行事务
        ft.commit();
    }

    private void hindFragment(FragmentTransaction ft) {
        if (tuijianFragment != null) {
            ft.hide(tuijianFragment);
        }
        if (shujiaFragment != null) {
            ft.hide(shujiaFragment);
        }
        if (fenleiFragment != null) {
            ft.hide(fenleiFragment);
        }
        if (gengduoFragment != null) {
            ft.hide(gengduoFragment);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_main_tuijian:
                setSelection(0);
                button_main_tuijian.setSelected(true);
                button_main_shujia.setSelected(false);
                button_main_fenlei.setSelected(false);
                button_main_gengduo.setSelected(false);
                break;
            case R.id.button_main_shujia:
                setSelection(1);
                button_main_tuijian.setSelected(false);
                button_main_shujia.setSelected(true);
                button_main_fenlei.setSelected(false);
                button_main_gengduo.setSelected(false);
                break;
            case R.id.button_main_fenlei:
                setSelection(2);
                button_main_tuijian.setSelected(false);
                button_main_shujia.setSelected(false);
                button_main_fenlei.setSelected(true);
                button_main_gengduo.setSelected(false);
                break;
            case R.id.button_main_gengduo:
                setSelection(3);
                button_main_tuijian.setSelected(false);
                button_main_shujia.setSelected(false);
                button_main_fenlei.setSelected(false);
                button_main_gengduo.setSelected(true);
                break;
        }
    }
}
