package com.seatcorporation.seat.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.seatcorporation.seat.Pages.RegSignin.Interfaces.IntRegSigninView;
import com.seatcorporation.seat.Pages.RegSignin.Presenters.PresenterRegSignin;
import com.seatcorporation.seat.R;
import com.seatcorporation.seat.Utils.UtilActivitiesNavigation;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Devrath on 10-09-2016.
 */
public class ActRegSignin extends AppCompatActivity implements IntRegSigninView {

    @BindView(R.id.btn_reg_id) Button btn_reg_id;
    @BindView(R.id.btn_signin_id) Button btn_signin_id;

    PresenterRegSignin presenter;
    CarouselView carouselView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_regsignin);
        //Inject views from butter-knife
        ButterKnife.bind(this);

        carouselView=(CarouselView) findViewById(R.id.carouselView) ;

        presenter =new PresenterRegSignin(this,carouselView);
    }



    @OnClick(R.id.btn_reg_id)
    public void registration() {
        UtilActivitiesNavigation.startActivityWithBackStackClear(ActRegSignin.this, ActRegistration.class);
        finish();
    }


    @OnClick(R.id.btn_signin_id)
    public void signIn() {

    }



    @Override
    public void registrationSuccess() {

    }

    @Override
    public void registrationFailure() {

    }

    @Override
    public void loadImage(int sampleImage, ImageView imageView) {
        Picasso.with(ActRegSignin.this)
                .load(sampleImage)
                .resize(600, 500)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(imageView);
    }
}