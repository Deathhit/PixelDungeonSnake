package tw.com.deathhit.pixel_dungeon_snake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Sprite {
    private Bitmap sheet;

    private Rect[] frameLocations;

    public Sprite(@NonNull Bitmap sheet, @NonNull Rect[] frameLocations){
        this.sheet = sheet;
        this.frameLocations = frameLocations;
    }

    public void draw(@NonNull Canvas canvas, @NonNull Rect dst, int frameIndex, @Nullable Paint paint){
        Rect src = frameLocations[frameIndex];

        canvas.drawBitmap(sheet, src, dst, paint);
    }

    public Bitmap getSheet() {
        return sheet;
    }

    public Rect getFrame(int index){
        return frameLocations[index];
    }

    public void recycle(){
        sheet.recycle();
        frameLocations = null;
    }

    public int size(){
        return frameLocations.length;
    }
}
