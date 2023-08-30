package com.example.pgtabme.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pgtabme.API.APIClient;
import com.example.pgtabme.R;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class DetailActivity extends AppCompatActivity {

    private  static String EXTRA_code="code";
    private  static String EXTRA_TITLE="title";
    private  static String EXTRA_DESCRIPTION="description";
    private  static String EXTRA_IMAGE_URL="image_url";
    private  static String EXTRA_CATEGORY="category";

    TextView txt_title,txt_description,txt_category,txt_code;
    ImageView img_image;
    Bundle extra;
    TextView txtShare;
    String code ;
    String title ;
    String description ;
    String category ;
    String image_url ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (APIClient.isNetworkAvailable(this)) {

           // txt_code = findViewById(R.id.title2);
            txt_title = findViewById(R.id.title);
            txt_description = findViewById(R.id.description);
            txt_category = findViewById(R.id.category);

            img_image = findViewById(R.id.app_bar_image);
            txtShare= findViewById(R.id.txt_share);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


            extra = getIntent().getExtras();

            if (extra != null) {
                code = extra.getString(EXTRA_code);
                 title = extra.getString(EXTRA_TITLE);
                 description = extra.getString(EXTRA_DESCRIPTION);
                 category = extra.getString(EXTRA_CATEGORY);
                 image_url = extra.getString(EXTRA_IMAGE_URL);


                getSupportActionBar().setTitle(" " + title);
           //     txt_code.setText(code);
                txt_title.setText(title);
                txt_category.setText(category);
                txt_description.setText(description);
                Glide.with(this)
                        .load(image_url)
                     //   .placeholder(R.drawable.load)
                        .into(img_image);

                txtShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       ShareData();
                    }
                }
            );



            }


        }
        else{
            Toast.makeText(this,"اتصال به اینترنت برقرار نیست",Toast.LENGTH_SHORT).show();
            Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.connection);
            Button button= dialog.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DetailActivity.this,DetailActivity.class));

                }
            });


            dialog.show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;

    }

//    @Override
//   protected void attachBaseContext(Context newBase) {
//       super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//   }

    public  void ShareData(){


        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String mytitle=title+Html.fromHtml("<br>")+description+Html.fromHtml("<br>" +
                "<b>اشتراک گذاری شده از  برنامه کاتالوگ محصولات پگاه </b>");
        intent.putExtra(Intent.EXTRA_TEXT,mytitle);

        startActivity(Intent.createChooser(intent,"اشتراک گذاری ار طریق..."));

    }

}
