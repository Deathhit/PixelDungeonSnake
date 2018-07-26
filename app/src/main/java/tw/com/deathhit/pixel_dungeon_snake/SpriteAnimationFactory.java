package tw.com.deathhit.pixel_dungeon_snake;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteAnimationFactory {
    public static ValueAnimator build(final Canvas canvas, Bitmap[] sprite){
        int[] indexes = new int[sprite.length];

        for(int i=0;i<sprite.length;i++)
            indexes[i] = i;

        ValueAnimator valueAnimator = ValueAnimator.ofInt(indexes);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int currentFrame = (int)valueAnimator.getAnimatedValue();

            }
        });


        return null;
    }
}
