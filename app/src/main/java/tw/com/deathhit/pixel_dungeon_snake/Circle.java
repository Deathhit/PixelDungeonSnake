package tw.com.deathhit.pixel_dungeon_snake;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle implements Renderer {
    private Paint mPaint;
    private float mRadius;

    public Circle(Paint p, float r){
        mPaint = p;
        mRadius = r;
    }

    @Override
    public void render(Canvas c){
        c.drawCircle(300, 300, mRadius, mPaint);

    }
}
