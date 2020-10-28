package dhruv.bandaria.s301102928;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
Name - Dhruv Bandaria
Student Id- 301102928
Section Number- 002
*/
public class DhruvFragment extends Fragment {
    PaintView paintView;
    Spinner sp,sp1;
    RelativeLayout rl;
    RelativeLayout.LayoutParams params;
    Button delete;
    int currentColor;
    float currentBrushSize;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_dhruv, container, false);

        sp=v.findViewById(R.id.spinner);
        sp1=v.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(getContext(),R.array.brush_size,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arrayAdapter1=ArrayAdapter.createFromResource(getContext(),R.array.brush_color,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp1.setAdapter(arrayAdapter1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        paintView.changeBrushSize(5f);
                        currentBrushSize=5f;
                        break;
                    case 1:
                        paintView.changeBrushSize(10f);
                        currentBrushSize=10f;
                        break;
                    case 2:
                        paintView.changeBrushSize(15f);
                        currentBrushSize=15f;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        paintView.changeColor(Color.RED);
                        currentColor=Color.RED;
                        break;
                    case 1:
                        paintView.changeColor(Color.GREEN);
                        currentColor=Color.GREEN;
                        break;
                    case 2:
                        paintView.changeColor(Color.BLUE);
                        currentColor=Color.BLUE;
                        break;
                    case 3:
                        paintView.changeColor(Color.YELLOW);
                        currentColor=Color.YELLOW;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        delete=v.findViewById(R.id.deleteButton);
        paintView=new PaintView(getContext(),null);
        rl=v.findViewById(R.id.cons_layout_dhruv_fragment);
        params=new RelativeLayout.LayoutParams(1100,1000);
        params.addRule(RelativeLayout.BELOW,R.id.name_and_studentId);
        params.topMargin=250;
        rl.addView(paintView,params);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.removeView(paintView);
                paintView=new PaintView(getContext(),null);
                rl.addView(paintView,params);
                paintView.changeColor(currentColor);
                paintView.changeBrushSize(currentBrushSize);
            }
        });

        return v;
    }
}