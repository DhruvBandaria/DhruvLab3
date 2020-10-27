package dhruv.bandaria.s301102928;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DhruvFragment extends Fragment {
    PaintView paintView;
    Button b1,b2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_dhruv, container, false);
        paintView=new PaintView(getContext(),null);
        RelativeLayout rl=v.findViewById(R.id.cons_layout_dhruv_fragment);
        final RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(1100,1000);
        params.addRule(RelativeLayout.BELOW,R.id.name_and_studentId);
        params.topMargin=250;
        rl.addView(paintView,params);

        b1=v.findViewById(R.id.button_temp1);
        b2=v.findViewById(R.id.button_temp2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.changeBrushSize(10f);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.changeBrushSize(15f);
            }
        });

        return v;
    }
}