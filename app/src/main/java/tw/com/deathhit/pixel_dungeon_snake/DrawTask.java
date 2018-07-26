package tw.com.deathhit.pixel_dungeon_snake;

import android.graphics.Canvas;
import android.os.AsyncTask;
import android.view.SurfaceHolder;

public class DrawTask<Progress, Result> extends AsyncTask<Renderer, Progress, Result> {
    private SurfaceHolder surfaceHolder;

    DrawTask(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    protected Result doInBackground(Renderer... renderers) {
        Canvas canvas = surfaceHolder.lockCanvas();

        if(canvas != null) {
            for (Renderer s : renderers)
                s.render(canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }else
            cancel(false);

        return null;
    }


}
