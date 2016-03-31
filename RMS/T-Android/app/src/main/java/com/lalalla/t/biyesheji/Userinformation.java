package com.lalalla.t.biyesheji;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Userinformation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private RelativeLayout container = null;
    private static final String STATES_KEY = "android:states";
    private Person person;
    private DBOpenHelper db;
    private String name;
    private static final String LOG_TAG = "Camera";
    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocalActivityManager = new LocalActivityManager(this, true);                               //后面继承的
        Bundle states = savedInstanceState != null
                ? (Bundle) savedInstanceState.getBundle(STATES_KEY) : null;
        mLocalActivityManager.dispatchCreate(states);
        setContentView(R.layout.activity_userinformation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        container = (RelativeLayout)findViewById(R.id.containerBody);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        RadioButton btnModule1 = (RadioButton) findViewById(R.id.btnModule1);
        RadioButton btnModule2 = (RadioButton) findViewById(R.id.btnModule2);
        RadioButton btnModule3 = (RadioButton) findViewById(R.id.btnModule3);
        btnModule1.setOnClickListener(this);
        btnModule2.setOnClickListener(this);
        btnModule3.setOnClickListener(this);
        container.addView(
                getLocalActivityManager().startActivity("Module1", new Intent(Userinformation.this, Module1.class)).getDecorView());
//                (v)->{container.removeAllViews();
//        container.addView(getLocalActivityManager().startActivity(
//                "Module1",//加载的activity名
//                new Intent(TestView.this, Module1.class)
//                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                .getDecorView());});
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Log.d(LOG_TAG, "Take Picture Button Click");
            // 利用系统自带的相机应用:拍照
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // create a file to save the image
            fileUri = Camerahelper.getOutputMediaFileUri(MEDIA_TYPE_IMAGE,getBaseContext().getExternalCacheDir().getParentFile());

            // 此处这句intent的值设置关系到后面的onActivityResult中会进入那个分支，即关系到data是否为null，如果此处指定，则后来的data为null
            // set the image file name
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
        else if (id == R.id.nav_gallery) {
            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//调用android的图库
            startActivityForResult(i, PHOTO_REQUEST_GALLERY);

        }
// else if (id == R.id.nav_gallery) {
//
//        }
//        else if (id == R.id.nav_slideshow) {
//
//        }
        else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

//           String[] email = {"3802**[email]92@qq.com[/email]"}; // 需要注意，email必须以数组形式传入");
//
//          Intent data=new Intent(Intent.ACTION_SENDTO);
//          data.setData(Uri.parse("mailto:way.ping.li@gmail.com"));
//          data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
//          data.putExtra(Intent.EXTRA_TEXT, "这是内容");
//          startActivity(data);
            Intent data=new Intent(Intent.ACTION_SENDTO);
            data.setData(Uri.parse("mailto:way.ping.li@gmail.com"));
            data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
            data.putExtra(Intent.EXTRA_TEXT, "这是内容");
            startActivity(data);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle state = mLocalActivityManager.saveInstanceState();
        if (state != null) {
            outState.putBundle(STATES_KEY, state);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLocalActivityManager.dispatchStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    protected LocalActivityManager mLocalActivityManager;
    public Activity getCurrentActivity() {
        return mLocalActivityManager.getCurrentActivity();
    }

    public final LocalActivityManager getLocalActivityManager() {
        return mLocalActivityManager;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnModule1:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module1",new Intent(Userinformation.this, Module1.class)).getDecorView());
                break;
            case R.id.btnModule2:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module2",new Intent(Userinformation.this, Module2.class)).getDecorView());
                break;
            case R.id.btnModule3:
                container.removeAllViews();
                container.addView(
                        getLocalActivityManager().startActivity("Module3",new Intent(Userinformation.this, Module3.class)).getDecorView());
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "onActivityResult: requestCode: " + requestCode
                + ", resultCode: " + requestCode + ", data: " + data);
        switch (requestCode) {
            // 如果是拍照
            case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE :
            {
                Log.d(LOG_TAG, "CAPTURE_IMAGE");

                if (RESULT_OK == resultCode) {
                    Log.d(LOG_TAG, "RESULT_OK");

                    // Check if the result includes a thumbnail Bitmap
                    if (data != null) {
                        // 没有指定特定存储路径的时候
                        Log.d(LOG_TAG,
                                "data is NOT null, file on default position.");

                        // 指定了存储路径的时候（intent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);）
                        // Image captured and saved to fileUri specified in the
                        // Intent
                        Toast.makeText(this, "Image saved to:\n" + data.getData(),
                                Toast.LENGTH_LONG).show();

                        if (data.hasExtra("data")) {
                            Bitmap thumbnail = data.getParcelableExtra("data");
//                        imageView.setImageBitmap(thumbnail);
                        }
                    } else {

                        Log.d(LOG_TAG,
                                "data IS null, file saved on target position.");
                        Toast.makeText(this, "照片已保存",
                                Toast.LENGTH_LONG).show();

                        // If there is no thumbnail image data, the image
                        // will have been stored in the target output URI.

                        // Resize the full image to fit in out image view.
//                    int width = imageView.getWidth();
//                    int height = imageView.getHeight();

                        BitmapFactory.Options factoryOptions = new BitmapFactory.Options();

                        factoryOptions.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(fileUri.getPath(), factoryOptions);

                        int imageWidth = factoryOptions.outWidth;
                        int imageHeight = factoryOptions.outHeight;

                        // Determine how much to scale down the image
//                    int scaleFactor = Math.min(imageWidth / width, imageHeight
//                            / height);

                        // Decode the image file into a Bitmap sized to fill the
                        // View
                        factoryOptions.inJustDecodeBounds = false;
//                    factoryOptions.inSampleSize = scaleFactor;
                        factoryOptions.inPurgeable = true;

                        Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                                factoryOptions);

//                    imageView.setImageBitmap(bitmap);
                    }
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "您已关闭了相机", Toast.LENGTH_SHORT).show();
                } else {
                    // Image capture failed, advise user
                }
                break;
            }
            case PHOTO_REQUEST_GALLERY: {
                switch (resultCode) {
                case Activity.RESULT_OK: {

                Uri uri = data.getData();
                Cursor cursor = getContentResolver().query(uri, null,
                        null, null, null);
                cursor.moveToFirst();

                Uri selectedImage = data.getData();
                String[] filePathColumns = {MediaStore.Images.Media.DATA};
                Cursor c = this.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                c.moveToFirst();

                int columnIndex = c.getColumnIndex(filePathColumns[0]);
                String picturePath = c.getString(columnIndex);
                c.close();


                String imgNo = cursor.getString(0); // 图片编号
                String imgPath = cursor.getString(1); // 图片文件路径
                String imgSize = cursor.getString(2); // 图片大小
                String imgName = cursor.getString(3); // 图片文件名
                cursor.close();
// Options options = new BitmapFactory.Options();
// options.inJustDecodeBounds = false;
// options.inSampleSize = 10;
// Bitmap bitmap = BitmapFactory.decodeFile(imgPath, options);
            }
                           case Activity.RESULT_CANCELED:// 取消
                           break;

            }
                break;



            // 如果是录像
//        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE)
//        {
//            Log.d(LOG_TAG, "CAPTURE_VIDEO");
//
//            if (resultCode == RESULT_OK)
//            {
//            }
//            else if (resultCode == RESULT_CANCELED)
//            {
//                // User cancelled the video capture
//            }
//            else
//            {
//                // Video capture failed, advise user
//            }
        }
    }
}}
