package dhruv.bandaria.s301102928;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class S301102928Fragment extends Fragment {

    ImageView iv;
    Button startAnimation,stopAnimation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_s301102928, container, false);
        iv=v.findViewById(R.id.imageView2);
        startAnimation=v.findViewById(R.id.startAnimation);
        stopAnimation=v.findViewById(R.id.stopAnimation);
        final Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate);

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(animation);
            }
        });
        stopAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.clearAnimation();
            }
        });


        return v;
    }
}