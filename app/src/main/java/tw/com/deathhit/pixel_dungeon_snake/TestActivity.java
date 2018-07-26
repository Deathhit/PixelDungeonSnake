package tw.com.deathhit.pixel_dungeon_snake;

import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.LinkedList;

import tw.com.deathhit.game.snake.Constants;
import tw.com.deathhit.game.snake.Food;
import tw.com.deathhit.game.snake.SimpleSnakeGame;
import tw.com.deathhit.game.snake.SimpleSnakeSegment;
import tw.com.deathhit.game.snake.core.Map;
import tw.com.deathhit.game.snake.core.SnakeGameModel;
import tw.com.deathhit.game.snake.core.SnakeSegment;
import tw.com.deathhit.pixel_dungeon_snake.core.BaseActivity;

public class TestActivity extends BaseActivity implements SurfaceHolder.Callback, Handler.Callback{
    private TimeAnimator timeAnimator;

    private ValueAnimator valueAnimator = new ValueAnimator();

    private SimpleSnakeGame game;

    private LinkedList<Path> pathQueue = new LinkedList<>();

    private Path path = new Path();

    private PathMeasure pathMeasure = new PathMeasure();

    private int mapWidth = 10;
    private int mapHeight = 10;

    Long delta = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        SurfaceView surfaceView = findViewById(R.id.surfaceView);

        surfaceView.getHolder().addCallback(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(SimpleSnakeGame.Turn.COUNTER_CLOCK_WISE);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(SimpleSnakeGame.Turn.CLOCK_WISE);
            }
        });

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Map map = new Map(mapWidth, mapHeight);


        map.put(new Food(), 7, 4);
        map.put(new Food(), 8, 4);
        map.put(new Food(), 9, 4);
        map.put(new Food(), 1, 4);


        SnakeGameModel model = new SnakeGameModel(map, new SimpleSnakeSegment(), 4, 4);

        model.snakeConcat(new SimpleSnakeSegment(), 3, 4);
        model.snakeConcat(new SimpleSnakeSegment(), 2, 4);

        HandlerThread thread = new HandlerThread("FOO");

        thread.start();

        game = new SimpleSnakeGame( model, thread.getLooper(), this);

        game.setDirection(1, 0);

        game.setDelay(500);

        game.start();
    }

    @Override
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int format, final int width, final int height) {
        final int length = width / mapWidth > height / mapHeight ? height / mapHeight : width / mapWidth;

        final Bitmap[] bat = AssetsProvider.createBatSprite(this, length, length, null);


        /*

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float[] pos = new float[2];

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Canvas canvas = surfaceHolder.lockCanvas();

                if(canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    SnakeGameModel model = simpleSnakeGame.getModel();

                    SnakeGameModel snake = model.getSnake();

                    pathMeasure.setPath(snake.getPath(), false);



                    for(int i=0;i<snake.size();i++){



                        pathMeasure.getPosTan(pathMeasure.getLength() - i - 1 + valueAnimator.getAnimatedFraction(), pos, null);

                        canvas.drawBitmap(bat[0],  pos[0]*length,  pos[1]*length , null);
                    }


                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        });

*/


        timeAnimator = new TimeAnimator();

        timeAnimator.setTimeListener(new TimeAnimator.TimeListener() {
            float[] pos = new float[2];



            @Override
            public void onTimeUpdate(TimeAnimator timeAnimator, long totalTime, long deltaTime) {
                SnakeGameModel model = game.getModel();



                Canvas canvas = surfaceHolder.lockCanvas();


                if (canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);


                    for (int i = 0; i < model.getSnakeSize(); i++)
                        canvas.drawBitmap(bat[0], model.getSegment(i).x * length , model.getSegment(i).y * length, null);

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }



            }
        });

        timeAnimator.start();



    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        timeAnimator.cancel();
    }

    @Override
    public boolean handleMessage(Message message) {

        SnakeGameModel model = game.getModel();

        switch (message.what){
            case Constants.MESSAGE_EAT :
            case Constants.MESSAGE_MOVE :


                return true;
            case Constants.MESSAGE_DIE :
                //timeAnimator.cancel();
                return true;
        }



        return false;
    }
}
