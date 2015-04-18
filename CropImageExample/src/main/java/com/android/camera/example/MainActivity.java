package com.android.camera.example;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;

public class MainActivity extends ActionBarActivity
  {
  private static final int REQUEST_PICTURE=1;
  private static final int REQUEST_CROP_PICTURE=2;

  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.button).setOnClickListener(new android.view.View.OnClickListener()
    {
    @Override
    public void onClick(final android.view.View v)
      {
      startActivityForResult(MediaStoreUtils.getPickImageIntent(MainActivity.this),REQUEST_PICTURE);
      }
    });
    imageView=(ImageView)findViewById(R.id.imageView);
    }

  @Override
  public boolean onCreateOptionsMenu(final Menu menu)
    {
    getMenuInflater().inflate(R.menu.activity_main,menu);
    return super.onCreateOptionsMenu(menu);
    }

  @SuppressWarnings("deprecation")
  @Override
  public boolean onOptionsItemSelected(final MenuItem item)
    {
    String url=null;
    switch(item.getItemId())
      {
      case R.id.menuItem_all_my_apps:
        url="https://play.google.com/store/apps/developer?id=AndroidDeveloperLB";
        break;
      case R.id.menuItem_all_my_repositories:
        url="https://github.com/AndroidDeveloperLB";
        break;
      case R.id.menuItem_current_repository_website:
        url="https://github.com/AndroidDeveloperLB/android-cropimage";
        break;
      }
    if(url==null)
      return true;
    final Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
    startActivity(intent);
    return true;
    }

  @Override
  protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    super.onActivityResult(requestCode,resultCode,data);
    if(resultCode!=RESULT_OK)
      return;
    File croppedImageFile=new File(getFilesDir(),"test.jpg");
    switch(requestCode)
      {
      case REQUEST_PICTURE:
        // When the user is done picking a picture, let's start the CropImage Activity,
        // setting the output image file and size to 200x200 pixels square.
        Uri croppedImage=Uri.fromFile(croppedImageFile);
        CropImageIntentBuilder cropImage=new CropImageIntentBuilder(200,200,croppedImage);
        cropImage.setOutlineColor(0xFF03A9F4);
        cropImage.setSourceImage(data.getData());
        startActivityForResult(cropImage.getIntent(this),REQUEST_CROP_PICTURE);
        break;
      case REQUEST_CROP_PICTURE:
        // When we are done cropping, display it in the ImageView.
        imageView.setImageBitmap(BitmapFactory.decodeFile(croppedImageFile.getAbsolutePath()));
        break;
      }
    }
  }
