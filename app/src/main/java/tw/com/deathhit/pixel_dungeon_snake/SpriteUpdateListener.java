package tw.com.deathhit.pixel_dungeon_snake;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;

public class SpriteUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final Bitmap[] sprite;

    public SpriteUpdateListener(Bitmap[] sprite){
        this.sprite = sprite;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {

    }
}
