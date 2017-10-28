package com.odinson.loki.mir_mosaic;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

   private enum NavigationFragment {
       PRODUCT_LIST,
       QR_SCANNER,
       CALCULATOR,
       USER,
       ABOUT
   }

    Toolbar tb;

    private BottomNavigationView.OnNavigationItemSelectedListener OnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.product_list:
                    ChangeFragment(NavigationFragment.PRODUCT_LIST);
                    return true;
                case R.id.qr_scanner:
                    ChangeFragment(NavigationFragment.QR_SCANNER);
                    return true;
                case R.id.calculator:
                    ChangeFragment(NavigationFragment.CALCULATOR);
                    return true;
                case R.id.user:
                    ChangeFragment(NavigationFragment.USER);
                    return true;
                case R.id.about:
                    ChangeFragment(NavigationFragment.ABOUT);
                    return true;
            }
            return false;
        }

    };

    private void ChangeFragment(NavigationFragment value){
        Fragment fragment = null;
        switch (value) {
            case PRODUCT_LIST:    fragment = new product_list();tb.setTitle(R.string.item1_title);  break;
            case QR_SCANNER: fragment = new qr_scanner();tb.setTitle(R.string.item2_title);break;
            case CALCULATOR: fragment= new calculator();tb.setTitle(R.string.item3_title);break;
            case USER: fragment= new user();tb.setTitle(R.string.item4_title);break;
            case ABOUT: fragment= new about();tb.setTitle(R.string.item5_title);break;
        }
        if(fragment!=null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
       // tite = (TextView)findViewById(R.id.tite);
        tb=(Toolbar)findViewById(R.id.toolbar_actionbar);
       // tb.setLogo(R.drawable.app_ico);






        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomnavigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.calculator);
        setSupportActionBar(tb);



    }

}