package tw.com.deathhit.pixel_dungeon_snake;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;

public class SpriteAnimator extends Animator {
    private ValueAnimator valueAnimator;

    private Bitmap[] sprite;

    SpriteAnimator(Bitmap[] sprite){

    }

    @Override
    public long getStartDelay() {
        return 0;
    }

    @Override
    public void setStartDelay(long l) {

    }

    @Override
    public Animator setDuration(long l) {
        return null;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public void setInterpolator(TimeInterpolator timeInterpolator) {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    public void setSprite(Bitmap[] sprite){
        this.sprite = sprite;

        int[] indexes = new int[sprite.length];

        for(int i=0;i<sprite.length;i++)
            indexes[i] = i;

        valueAnimator = ValueAnimator.ofInt(indexes);


    }
}
