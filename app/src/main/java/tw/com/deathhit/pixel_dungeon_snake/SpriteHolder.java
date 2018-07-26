package tw.com.deathhit.pixel_dungeon_snake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class SpriteHolder {
    private static final long FRAME_TICKER = (long).01;

    private Sprite sprite;

    private Paint paint;

    private long updatedTime;
    private long timePerFrame;

    private int currentIndex;

    private boolean repeat = false;
    private boolean pause = false;

    public SpriteHolder(Sprite sprite, long duration){
        setSprite(sprite);
        setDuration(duration);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Rect dst){
        if(sprite != null)
            sprite.draw(canvas, dst, currentIndex, paint);
    }

    @Nullable
    public Paint getPaint() {
        return paint;
    }

    @Nullable
    public Sprite getSprite(){
        return sprite;
    }

    /***Reset current time and current index.***/
    public void reset(){
        updatedTime = System.currentTimeMillis();
        currentIndex = 0;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
        reset();
    }

    public void setDuration(long duration){
        timePerFrame = duration/sprite.size();
    }

    public void setRepeat(boolean repeat){
        this.repeat = repeat;
    }

    public void setPaint(Paint paint){
        this.paint = paint;
    }

    public void setPause(boolean pause){
        this.pause = pause;
    }

    /***Check input time ,and move to the next frame if needed.***/
    public void update(long time){
        if(time - updatedTime > timePerFrame + FRAME_TICKER){
            updatedTime = time;

            if(pause)
                return;

            currentIndex++;

            if(currentIndex >= sprite.size())
                if(repeat)
                    currentIndex = 0;
                else
                    currentIndex--;
        }
    }

    /***Check system time ,and move to the next frame if needed.***/
    public void update(){
        this.update(System.currentTimeMillis());
    }
}