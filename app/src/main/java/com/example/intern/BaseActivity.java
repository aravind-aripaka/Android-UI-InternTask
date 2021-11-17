package com.example.intern;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import de.hdodenhof.circleimageview.CircleImageView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    boolean bIsRecentExpanded = false;
    ArrayList<LinearLayout> userdatalist = new ArrayList<>();
    LinearLayout btnRecentView = null;
    LinearLayout recentcontactslayout = null;
    LinearLayout recentslayout = null;
    LinearLayout useraccountlayout = null;
    LinearLayout receiverlayout = null;
    LinearLayout returnlayout = null;
    ArrayList<LinearLayout> frequentUserLayouts = new ArrayList<>();
    LinearLayout freqlayout = null;
    ImageClick imageClick = new ImageClick();
    ImageView btnaccountup = null;

    LinearLayout usergroup = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Demo App");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        btnRecentView = findViewById(R.id.btnrecentslayout);
        btnRecentView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bIsRecentExpanded = false;
                ShoworHideRecentUsers();
            }
        });
        freqlayout = findViewById(R.id.freqlayout);
        ShowFrequentUsers();
        useraccountlayout = findViewById(R.id.useraccountlayout);
        recentslayout =  findViewById(R.id.recentslayout);
        recentcontactslayout = findViewById(R.id.recentcontactslayout);
        ShowRecentUsers();
        recentslayout.setVisibility(View.GONE);
        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();

        pieData.add(new SliceValue(2, Color.RED));
        pieData.add(new SliceValue(5, Color.rgb(255,69,0)));
        pieData.add(new SliceValue(93, Color.GREEN));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasCenterCircle(true).setCenterText1("93% returned").setCenterText1FontSize(15).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
        receiverlayout = findViewById(R.id.receiverlayout);
        returnlayout = findViewById(R.id.returnlayout);
        TextView btnreturn = findViewById(R.id.btnreturn);
        TextView btnReceived = findViewById(R.id.btnreceived);
        TableRow rownext10days = findViewById(R.id.rownext10days);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiverlayout.setVisibility(View.GONE);
                returnlayout.setVisibility(View.VISIBLE);
                btnreturn.setText(R.string.returnunderline);
                btnreturn.setTypeface(btnreturn.getTypeface(), Typeface.BOLD);
                btnReceived.setText(R.string.receive);
                btnReceived.setTypeface(btnReceived.getTypeface(), Typeface.NORMAL);
                rownext10days.setVisibility(View.GONE);
            }
        });


        btnReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnreturn.setText(R.string.return1);
                btnReceived.setText(R.string.receiveunderline);
                receiverlayout.setVisibility(View.VISIBLE);
                returnlayout.setVisibility(View.GONE);
                btnreturn.setTypeface(btnreturn.getTypeface(), Typeface.NORMAL);
                btnReceived.setTypeface(btnReceived.getTypeface(), Typeface.BOLD);
                rownext10days.setVisibility(View.VISIBLE);
            }
        });

        btnaccountup = findViewById(R.id.btnaccountup);
        btnaccountup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bIsRecentExpanded = false;
                ShoworHideRecentUsers();
            }
        });
        usergroup= findViewById(R.id.usergroup);
        usergroup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bIsRecentExpanded = true;
                ShoworHideRecentUsers();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
        return true;
    }

    private void ShowFrequentUsers(){
        ImageClick imageClick = new ImageClick();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
        layoutParams.topMargin = 10;
        layoutParams.leftMargin = 15;
        layoutParams.rightMargin= 15;
        layoutParams.bottomMargin = 10;
        ArrayList<Userdata> userlist = new ArrayList<>();
        userlist.add( new Userdata(R.drawable.user1, "Aravind", "Sudarhan", 120));
        userlist.add( new Userdata(R.drawable.user2, "Bhaskara", "Sundaram", 400));
        userlist.add( new Userdata(R.drawable.user3, "Naveen", "Kumar",500));
        userlist.add( new Userdata(R.drawable.user4, "Ravindra","Manju",450));
        userlist.add( new Userdata(R.drawable.downarrow, "Recents","",0));
        userlist.add( new Userdata(R.drawable.user5, "Abhi","Raghu",690));

        userlist.add( new Userdata(R.drawable.user6, "Mahaveer","Sekhar", 560));
        userlist.add( new Userdata(R.drawable.user7, "ShantaRam","Rajani", 375));


    /*  userlist.add( new Userdata(R.drawable.user8, "Krishna"));
        userlist.add( new Userdata(R.drawable.user9, "Raghu"));
        userlist.add( new Userdata(R.drawable.user10, "Raja"));
        userlist.add( new Userdata(R.drawable.user11, "Venkat"));
        userlist.add( new Userdata(R.drawable.user12, "Sankar"));
        userlist.add( new Userdata(R.drawable.user13, "Gopi"));
        userlist.add( new Userdata(R.drawable.user14, "Manish")); */
        LinearLayout rowlayout = null;
        for(int i=0; i<userlist.size();i++) {
            if(i==0 || i%6 == 0) {
                //Create a linear layout
                rowlayout = new LinearLayout(this);
                frequentUserLayouts.add(rowlayout);
                //Set LayoutParams
                LinearLayout.LayoutParams lp = new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                //Set to horizontal layout
                rowlayout.setOrientation (LinearLayout.HORIZONTAL);
                lp.topMargin = 10;
                lp.bottomMargin = 10;
                lp.leftMargin = 10;
                //This is LayoutParams for linear layout
                rowlayout.setLayoutParams (lp);

                freqlayout.addView(rowlayout);
            }

            LinearLayout userdatalayout = new LinearLayout(this);
            LinearLayout.LayoutParams userlp = new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            //Set to horizontal layout
            userdatalayout.setOrientation (LinearLayout.VERTICAL);

            //This is LayoutParams for linear layout
            userdatalayout.setLayoutParams (userlp);

            CircleImageView circleImageView = new CircleImageView(this);
            circleImageView.setId(userlist.get(i).imageid);
            circleImageView.setImageResource(userlist.get(i).imageid);
            circleImageView.setOnClickListener(imageClick);
            circleImageView.setTag(userlist.get(i));

            circleImageView.setLayoutParams(layoutParams);
            circleImageView.setBackgroundColor(Color.TRANSPARENT);
            circleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            userdatalayout.addView(circleImageView);
            TextView textView = new TextView(this);
            textView.setText(userlist.get(i).username);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(10f);
            textView.setGravity(Gravity.CENTER);
            userdatalayout.addView(textView);
            userdatalayout.setId(userlist.get(i).imageid);
            userdatalist.add(userdatalayout);
            if(bIsRecentExpanded){
                if(userlist.get(i).imageid == R.drawable.downarrow){
                    userdatalayout.setVisibility(View.GONE);
                }
                if(i > 5){
                    userdatalayout.setVisibility(View.VISIBLE);
                }
            }
            else{
                if(userlist.get(i).imageid == R.drawable.downarrow){
                    userdatalayout.setVisibility(View.VISIBLE);
                }
                if(i > 4){
                    userdatalayout.setVisibility(View.GONE);
                }
            }
            rowlayout.addView(userdatalayout);
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) userdatalayout.getLayoutParams();
            marginParams.setMargins(marginParams.leftMargin,
                    marginParams.topMargin,
                    30, //notice only changing right margin
                    marginParams.bottomMargin);


        }
   }

    private void ShowRecentUsers(){

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
        layoutParams.topMargin = 10;
        layoutParams.leftMargin = 15;
        layoutParams.rightMargin= 15;
        layoutParams.bottomMargin = 10;
        ArrayList<Userdata> userlist = new ArrayList<>();
        userlist.add( new Userdata(R.drawable.user8, "Krishna","Mahesh",235));
        userlist.add( new Userdata(R.drawable.user9, "Raghu","Shey", 3689));
        userlist.add( new Userdata(R.drawable.user10, "Raja","Shanker",488));
        userlist.add( new Userdata(R.drawable.user11, "Venkat","Janardhan",468));
        userlist.add( new Userdata(R.drawable.user12, "Sankar","Rathna",3489));
        userlist.add( new Userdata(R.drawable.user13, "Gopi","Pavan",789));
        userlist.add( new Userdata(R.drawable.user14, "Manish","Kumar",4598));
        userlist.add( new Userdata(R.drawable.user15, "Anshul","Nigam",4554));
        userlist.add( new Userdata(R.drawable.user16, "Shyam","Raghu", 342));
        userlist.add( new Userdata(R.drawable.user17, "Rahul","Bill", 455));
        userlist.add( new Userdata(R.drawable.user18, "Allen", "Seegmiller",4333));
        userlist.add( new Userdata(R.drawable.user19, "Jemmy","Watson",2345));
        userlist.add( new Userdata(R.drawable.user20, "Roy Shey","Guy", 5444));
        userlist.add( new Userdata(R.drawable.user21, "Gabbi","Reymond",433));
        userlist.add( new Userdata(R.drawable.user22, "Toby","Danil", 4444));
        userlist.add( new Userdata(R.drawable.user23, "Jobi","Bhaskara",333));
        userlist.add( new Userdata(R.drawable.user24, "Sekhar","Suresh",487));
        userlist.add( new Userdata(R.drawable.user25, "Sameer","Wankede",344));
        userlist.add( new Userdata(R.drawable.user26, "Madhavi", "Latha",4455));
        userlist.add( new Userdata(R.drawable.user27, "Divya","Prabha",543));
        userlist.add( new Userdata(R.drawable.user28, "Chandu","Abhi", 908));
        LinearLayout rowlayout = null;

        for(int i=0; i<userlist.size();i++) {
            if(i==0 || i%5 == 0) {
                //Create a linear layout
                rowlayout = new LinearLayout(this);
                //Set LayoutParams
                LinearLayout.LayoutParams lp = new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                //Set to horizontal layout
                rowlayout.setOrientation (LinearLayout.HORIZONTAL);
                lp.topMargin = 10;
                lp.bottomMargin = 10;
                lp.leftMargin = 10;
                //This is LayoutParams for linear layout
                rowlayout.setLayoutParams (lp);

                recentcontactslayout.addView(rowlayout);
            }

            LinearLayout userdatalayout = new LinearLayout(this);
            LinearLayout.LayoutParams userlp = new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            //Set to horizontal layout
            userdatalayout.setOrientation (LinearLayout.VERTICAL);

            //This is LayoutParams for linear layout
            userdatalayout.setLayoutParams (userlp);

            CircleImageView circleImageView = new CircleImageView(this);
            circleImageView.setId(userlist.get(i).imageid);
            circleImageView.setImageResource(userlist.get(i).imageid);
            circleImageView.setOnClickListener(imageClick);
            circleImageView.setTag(userlist.get(i));

            circleImageView.setLayoutParams(layoutParams);
            circleImageView.setBackgroundColor(Color.TRANSPARENT);
            circleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            userdatalayout.addView(circleImageView);
            TextView textView = new TextView(this);
            textView.setText(userlist.get(i).username);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(10f);
            textView.setGravity(Gravity.CENTER);
            userdatalayout.addView(textView);
            userdatalayout.setId(userlist.get(i).imageid);
            userdatalist.add(userdatalayout);
            rowlayout.addView(userdatalayout);
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) userdatalayout.getLayoutParams();
            marginParams.setMargins(marginParams.leftMargin,
                    marginParams.topMargin,
                    30, //notice only changing right margin
                    marginParams.bottomMargin);


        }
    }

    private void ShoworHideRecentUsers(){
        if(bIsRecentExpanded){
            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    0,                 // fromYDelta
                    useraccountlayout.getHeight()); // toYDelta
            animate.setDuration(500);
            animate.setFillAfter(false);
            animate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}
                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationEnd(Animation animation) {
              //      useraccountlayout.setVisibility(View.VISIBLE);
                    recentslayout.setVisibility(View.VISIBLE);
                    btnaccountup.setVisibility(View.VISIBLE);
                    for(LinearLayout userprofile: userdatalist){
                        if(userprofile.getId() == (int)R.drawable.downarrow){
                            userprofile.setVisibility(View.GONE);
                        }
                        else{
                            userprofile.setVisibility(View.VISIBLE);
                        }
                    }

                }




            });

            useraccountlayout.startAnimation(animate);
            for(int i=1;i< frequentUserLayouts.size();i++){
                frequentUserLayouts.get(i).setVisibility(View.VISIBLE);
            }
        }
        else{
            for(int i=1;i< frequentUserLayouts.size();i++){
                frequentUserLayouts.get(i).setVisibility(View.GONE);
            }

            btnaccountup.setVisibility(View.GONE);
            recentslayout.setVisibility(View.GONE);
            for(int i=0; i<userdatalist.size(); i++){
                if(userdatalist.get(i).getId() == (int)R.drawable.downarrow){
                    userdatalist.get(i).setVisibility(View.VISIBLE);
                }
                else{
                    if(i>4)
                       userdatalist.get(i).setVisibility(View.GONE);

                }
            }


            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    useraccountlayout.getHeight(), // fromYDelta
                    0); // toYDelta
            animate.setDuration(500);
            animate.setFillAfter(false);
            animate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}
                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationEnd(Animation animation) {
                    useraccountlayout.setVisibility(View.VISIBLE);

                }




            });

            useraccountlayout.startAnimation(animate);
        }
    }

    private class ImageClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.drawable.downarrow:
                    bIsRecentExpanded = !bIsRecentExpanded;
                    ShoworHideRecentUsers();
                    break;
                default:
                        Userdata userdata = (Userdata) v.getTag();
                        Utility.userdata = userdata;
                        Intent myIntent = new Intent(BaseActivity.this, Screen4.class);
                        BaseActivity.this.startActivity(myIntent);
                        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

                        break;
            }
        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
}