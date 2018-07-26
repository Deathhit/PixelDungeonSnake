package tw.com.deathhit.pixel_dungeon_snake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class PathSprite implements Renderer {
    private Path path;
    private Paint paint;

    public PathSprite(Path path, Paint paint){
        this.path = path;
        this.paint = paint;
    }

    @Override
    public void render(Canvas canvas) {

    }
}
