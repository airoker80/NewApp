package com.harati.np.newapp.ui.Activity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.harati.np.newapp.ui.Fragment.BookFragment;
import com.harati.np.newapp.ui.Fragment.MyActivityFragment;
import com.harati.np.newapp.ui.Fragment.PracticeFragment;
import com.harati.np.newapp.ui.Fragment.QuestionFragment;
import com.harati.np.newapp.ui.Fragment.QuizFragment;
import com.harati.np.newapp.ui.Fragment.SyllabusFragment;
import com.harati.np.newapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment=null;

    @BindView(R.id.books) TextView books;
    @BindView(R.id.my_activity) TextView my_activity;
    @BindView(R.id.practice) TextView practice;
    @BindView(R.id.questions) TextView questions;
    @BindView(R.id.quiz) TextView quiz;
    @BindView(R.id.syllabus) TextView syllabus;
    @BindView(R.id.dashboard) TextView dashboard;


    @OnClick(R.id.dashboard) void dashboard(){
        fragment = new BookFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(dashboard);
        closeDrawer();
    }
    @OnClick(R.id.books) void showBooks(){
        fragment = new BookFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(books);
        closeDrawer();
    }
    @OnClick(R.id.questions) void showquestions(){
        fragment = new QuestionFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(questions);
        closeDrawer();
    }
    @OnClick(R.id.practice) void showPractice(){
        fragment = new PracticeFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(practice);
        closeDrawer();
    }
    @OnClick(R.id.quiz) void showQuiz(){
        fragment = new QuizFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(quiz);
        closeDrawer();
    }
    @OnClick(R.id.my_activity) void show_my_activity (){
        fragment = new MyActivityFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(my_activity);
        closeDrawer();
    }
    @OnClick(R.id.syllabus) void show_syllabus (){
        fragment = new SyllabusFragment();
        setCurrentFragment(false,R.id.books,"Books");
        resetSelectedPageDrawable(syllabus);
        closeDrawer();
    }
    @OnClick(R.id.logout) void logout (){}
    public void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    public void setCurrentFragment(Boolean saveFragmentBackstack, int id, String backPageName){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (saveFragmentBackstack) {
            fragmentTransaction.addToBackStack(null);
        }

        if(backPageName.length()>0){
            Bundle args = new Bundle();
            args.putString("returnPage",backPageName);
            fragment.setArguments(args);
        }
        fragmentTransaction.replace(R.id.content_frame, fragment,String.valueOf(id)+"tag");
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment = new BookFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment,"");
        fragmentTransaction.commit();

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.upload:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    View currentSelectedPage;
    public void resetSelectedPageDrawable(View selectedView){
        if(currentSelectedPage!=null){
            currentSelectedPage.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_menu_normal_state));
        }
        currentSelectedPage = selectedView;
        currentSelectedPage.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_menu_selected_item));
    }
}
