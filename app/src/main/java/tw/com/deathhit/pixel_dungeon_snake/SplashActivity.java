package tw.com.deathhit.pixel_dungeon_snake;

import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.animation.TranslateAnimation;

import tw.com.deathhit.game.snake.core.Map;
import tw.com.deathhit.game.snake.core.SnakeGameModel;
import tw.com.deathhit.pixel_dungeon_snake.core.BaseActivity;

public class SplashActivity extends BaseActivity implements SurfaceHolder.Callback{
    private ValueAnimator valueAnimator;

    private TimeAnimator timeAnimator;

    private AnimationDrawable smith;

    private TranslateAnimation translateAnimation;

    private TranslateAnimation translateAnimation2;

    private TranslateAnimation translateAnimation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        //SurfaceView surfaceView = findViewById(R.id.surfaceView);

        /*
        smith = AssetsProvider.createBlackSmithSprite(this, 100, 100, null);

        smith.setOneShot(false);

        //surfaceView.getHolder().addCallback(this);

        ImageView imageView = findViewById(R.id.imageView2);

        imageView.setImageDrawable(smith);

        translateAnimation = new TranslateAnimation(100, 200 , 100, 200);

        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setDuration(2200);

        imageView.setAnimation(translateAnimation);

        final ImageView imageView2 = findViewById(R.id.imageView);

        final ImageView imageView3 = findViewById(R.id.imageView3);

        imageView2.post(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = AssetsProvider.createBackground(SplashActivity.this, (int)(imageView2.getWidth()*1.1), imageView2.getHeight(), null);



                imageView2.setImageBitmap(bitmap);
                imageView3.setImageBitmap(bitmap);


                translateAnimation2 = new TranslateAnimation(0, 0, 0, -imageView2.getHeight());
                translateAnimation2.setInterpolator(new LinearInterpolator());
                translateAnimation2.setRepeatCount(Animation.INFINITE);
                translateAnimation2.setDuration(4000);

                translateAnimation3 = new TranslateAnimation(0, 0, imageView2.getHeight(), 0);
                translateAnimation3.setInterpolator(new LinearInterpolator());
                translateAnimation3.setRepeatCount(Animation.INFINITE);
                translateAnimation3.setDuration(4000);


                imageView2.setAnimation(translateAnimation2);
                imageView3.setAnimation(translateAnimation3);

                translateAnimation2.start();
                translateAnimation3.start();
            }
        });
        */




    }

    @Override
    protected void onResume(){
        super.onResume();

        /*
        smith.start();



        translateAnimation.start();

        if(translateAnimation2 != null) {
            translateAnimation2.start();
            translateAnimation3.start();
        }
        */

    }

    @Override
    protected void onPause(){
        super.onPause();

        /*
        smith.stop();

        translateAnimation.cancel();
        if(translateAnimation2 != null) {
            translateAnimation2.cancel();
            translateAnimation3.cancel();
        }
        */
    }

    @Override
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {

        final Path path = new Path();

        path.addRect(100, 100 , 200, 200, Path.Direction.CW);

        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.WHITE);

        /*
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float[] position = new float[2];

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                float val = valueAnimator.getAnimatedFraction();
                PathMeasure pathMeasure = new PathMeasure(path, true);
                pathMeasure.getPosTan(pathMeasure.getLength() * val, position, null);

                Canvas canvas = surfaceHolder.lockCanvas();

                if(canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    canvas.drawCircle(position[0], position[1], 10, paint);

                    bm.drawCanvas(canvas, new Rect(200, 200, 300, 300), (int)(val*3));


                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        });

        valueAnimator.setDuration(1500);
        valueAnimator.setInterpolator(new AccelerateInterpolator(2));

        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.start();
        */

        //new DrawTask<>(surfaceHolder).execute(new Circle(paint, 200f));
    }

    @Override
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int format, final int width, final int height) {
        /*

        Paint paint = new Paint();

        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN));

        final Bitmap sprite = AssetsProvider.createBackground(this, width, (int)(height*1.25), paint);

        ValueAnimator.setFrameDelay(100);

        valueAnimator = ValueAnimator.ofInt(0, -height/4);

        valueAnimator.setStartDelay(0);

        valueAnimator.setDuration(2000);

        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.setRepeatMode(ValueAnimator.RESTART);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Canvas canvas = surfaceHolder.lockCanvas();

                if(canvas != null){
                    int delta = (int)valueAnimator.getAnimatedValue();

                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    canvas.translate(0, delta);

                    canvas.drawBitmap(sprite, 0, 0, null);

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        });

        valueAnimator.start();

       */

        /*
        final Bitmap[] sprite = AssetsProvider.createBlackSmithSprite(this, width, height, null);

        valueAnimator = ValueAnimator.ofInt(0, 4);

        valueAnimator.setInterpolator(new AccelerateInterpolator());

        valueAnimator.setDuration(1500);

        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.setRepeatMode(ValueAnimator.RESTART);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Canvas canvas = surfaceHolder.lockCanvas();

                if(canvas != null) {
                    int index = (int)valueAnimator.getAnimatedValue();

                    //toast(sprite.length+"");

                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    canvas.drawBitmap(sprite[index], 0 , 0 , new Paint());

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        });

        valueAnimator.start();
        */


        AnimationDrawable blacksmith = AssetsProvider.createBlackSmithSprite(this , width, height, null);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        valueAnimator.cancel();
    }
}

