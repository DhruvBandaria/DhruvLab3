package dhruv.bandaria.s301102928;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
/*
Name - Dhruv Bandaria
Student Id- 301102928
Section Number- 002
*/
public class PaintView extends View {

    public static int Brush_Size=10;
    public static final int DEFAULT_COLOR= Color.RED;
    public static final int BACKGROUND_COLOR=Color.GRAY;
    public Paint paint;
    public Path path;
    Canvas c;
    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setDefault();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c=canvas;
        c.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos=event.getX();
        float yPos=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();

        return true;
    }

    public void setDefault(){
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(DEFAULT_COLOR);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    public void changeBrushSize(float size){
        paint.setStrokeWidth(size);
    }

    public void changeColor(int color){
        paint.setColor(color);
    }

}
