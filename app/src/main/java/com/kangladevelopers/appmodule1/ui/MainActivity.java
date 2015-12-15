package com.kangladevelopers.appmodule1.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kangladevelopers.appmodule1.R;
import com.kangladevelopers.appmodule1.fragment.Fragment2;
import com.kangladevelopers.appmodule1.fragment.Fragment3;
import com.kangladevelopers.appmodule1.fragment.Fragment4;
import com.kangladevelopers.appmodule1.fragment.FragmentDrawer;
import com.kangladevelopers.appmodule1.fragment.HomeFragment;
import com.soundcloud.android.crop.Crop;

import java.io.File;



public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

   // private Toolbar toolbar;
    private FragmentDrawer fragmentDrawer;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private static Fragment CURRENT_FRAGMENT;
    private HomeFragment homeFragment;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private String imgDecodableString;
    private Fragment4 fragment4;
    // made some changes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // toolbar = (Toolbar) findViewById(R.id.toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.container_body);
        //setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentDrawer = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragmentDrawer.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        fragmentDrawer.setDrawerListener(this);
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        CURRENT_FRAGMENT = homeFragment;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_body, homeFragment, "F1");
        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        String title = "";
        TextView textView = (TextView) view.findViewById(R.id.title);
        title = textView.getText().toString();
        Toast.makeText(getApplicationContext(), "onDrawerItemSelected\n Value: " + title, Toast.LENGTH_LONG).show();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                if (!(CURRENT_FRAGMENT instanceof HomeFragment)) {
                    fragmentTransaction.remove(CURRENT_FRAGMENT);
                    fragmentTransaction.add(R.id.container_body, homeFragment, "F1");
                    fragmentTransaction.commit();
                    CURRENT_FRAGMENT = homeFragment;

                }

                break;
            case 1:
                if (!(CURRENT_FRAGMENT instanceof Fragment2)) {
                    fragmentTransaction.remove(CURRENT_FRAGMENT);
                    fragmentTransaction.add(R.id.container_body, fragment2, "F2");
                    fragmentTransaction.commit();
                    CURRENT_FRAGMENT =fragment2;

                }
                break;
            case 2:
                if (!(CURRENT_FRAGMENT instanceof Fragment3)) {
                    fragmentTransaction.remove(CURRENT_FRAGMENT);
                    fragmentTransaction.add(R.id.container_body, fragment3, "F3");
                    fragmentTransaction.commit();
                    CURRENT_FRAGMENT =fragment3;

                }
                break;

            case 3:
                if (!(CURRENT_FRAGMENT instanceof Fragment4)) {
                    fragmentTransaction.remove(CURRENT_FRAGMENT);
                    fragmentTransaction.add(R.id.container_body, fragment4, "F4");
                    fragmentTransaction.commit();
                    CURRENT_FRAGMENT =fragment4;

                }


                break;

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        // 196729
        try {
            if(requestCode ==Crop.REQUEST_CROP){
                handleCrop(resultCode,data);
                return;
            }
            biginCrop(data.getData());

        }
        catch (Exception e){
            e.printStackTrace();
        }


       /* try {
            // When an Image is picked
            if (requestCode == 196729 && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                FragmentDrawer.getProfileImage().setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();



            } else {
                Toast.makeText(getApplicationContext(), "You haven't picked Image"+"Request code:: "+requestCode+"result::"+resultCode+"data:: "+data,
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }*/
    }

    public void biginCrop(Uri source){
        // creating the destination folder in the cache directory of the application
        Uri destination= Uri.fromFile(new File(getCacheDir(),"croppedImages"));
        // starting the crop activity to perform cropping
        Crop.of(source,destination).asSquare().start(this);


    }
    public void handleCrop(int resultCode,Intent result){

        if(resultCode==RESULT_OK){
            FragmentDrawer.getProfileImage().setImageURI(Crop.getOutput(result));

        }
    }
}
