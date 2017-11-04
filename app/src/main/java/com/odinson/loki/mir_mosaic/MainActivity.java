package com.odinson.loki.mir_mosaic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

   private enum NavigationFragment {
       PRODUCT_LIST,
       QR_SCANNER,
       CALCULATOR,
       USER,
       ABOUT
   }

    Toolbar tb;
    ActionBar ab;
    TextView tt;
    TextView st;




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
            case PRODUCT_LIST:    fragment = product_list.newInstance();st.setText("Product List");tt.setText("MirMosaic");  break;
            case QR_SCANNER: fragment = new qr_scanner();st.setText("QR Scanner");tt.setText("MirMosaic");break;
            case CALCULATOR: fragment= new calculator();st.setText("Calculator");tt.setText("MirMosaic");break;
            case USER: fragment= new user();st.setText("User");tt.setText("MirMosaic");break;
            case ABOUT: fragment= new about();st.setText("About");tt.setText("MirMosaic");break;
        }

        if(fragment!=null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.grow_from_middle,R.anim.shrink_to_middle)
                    .replace(R.id.content, fragment)
                    .commit();

    }

    /*private void flipcard(Fragment fragment){
        Boolean mShowingBack =false;
        if (mShowingBack){
            getSupportFragmentManager().popBackStack();
            return;
        }
        mShowingBack = true;

        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.animator.flip_right_in,R.animator.flip_tight_out,R.animator.flip_left_in,R.animator.flip_left_out)
                .replace(R.id.content,fragment)
                .addToBackStack(null)
                .commit();


    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);


        tb=(Toolbar)findViewById(R.id.toolbar_actionbar);
        tb.setTitle("");
        tt= (TextView)findViewById(R.id.tite);
        st =(TextView)findViewById(R.id.subtite);
        tt.setText("MirMosaic");








        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomnavigation);
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.calculator);
        setSupportActionBar(tb);

        ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(false);





    }

}
