package dhruv.bandaria.s301102928;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class BandariaFragment extends Fragment {

    Button button,startAnimation,stopAnimation;
    ImageView iv;
    AnimationDrawable animationDrawable = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_bandaria, container, false);
        button=v.findViewById(R.id.open_call);
        startAnimation=v.findViewById(R.id.startFrameAnimation);
        stopAnimation=v.findViewById(R.id.stopFrameAnimation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+34666777888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        stopAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
        iv=v.findViewById(R.id.framedAnimation);
        return v;
    }

    private void startAnimation(){
        BitmapDrawable frame1=(BitmapDrawable) getResources().getDrawable(R.drawable.frame1);
        BitmapDrawable frame2=(BitmapDrawable) getResources().getDrawable(R.drawable.frame2);
        BitmapDrawable frame3=(BitmapDrawable) getResources().getDrawable(R.drawable.frame3);
        BitmapDrawable frame4=(BitmapDrawable) getResources().getDrawable(R.drawable.frame4);
        BitmapDrawable frame5=(BitmapDrawable) getResources().getDrawable(R.drawable.frame5);

        int reasonableDuration = 250;

        animationDrawable=new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(frame1,reasonableDuration);
        animationDrawable.addFrame(frame2,reasonableDuration);
        animationDrawable.addFrame(frame3,reasonableDuration);
        animationDrawable.addFrame(frame4,reasonableDuration);
        animationDrawable.addFrame(frame5,reasonableDuration);

        iv.setBackground(animationDrawable);
        animationDrawable.setVisible(true,true);
        animationDrawable.start();
        iv.setVisibility(View.VISIBLE);

    }
    private void stopAnimation(){
        animationDrawable.stop();
        animationDrawable.setVisible(false,false);
        iv.setVisibility(View.INVISIBLE);
    }
}