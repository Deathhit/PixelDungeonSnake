package tw.com.deathhit.pixel_dungeon_snake;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class AssetsProvider {
    /**sh_blacksmith.png : 64*16 => Sprite 4 frames**/
    public static AnimationDrawable createBlackSmithSprite(Context context, int width, int height, @Nullable Paint paint){
        Bitmap sheet = getBitmapFromAsset(context, "sh_blacksmith.png");

        Rect[] src = new Rect[4];

        for(int i=0;i<4;i++)
            src[i] = new Rect(i*13, 0, (i+1)*13, 16);

        assert sheet != null;
        Bitmap.Config config = sheet.getConfig();

        Canvas canvas = new Canvas();

        Bitmap[] sprite = new Bitmap[4];

        Rect dst = new Rect(0, 0, width, height);

        AnimationDrawable animationDrawable = new AnimationDrawable();

        for(int i=0;i<4;i++){
            sprite[i] = Bitmap.createBitmap(width, height, config);

            canvas.setBitmap(sprite[i]);

            canvas.drawBitmap(sheet, src[i], dst, paint);

            animationDrawable.addFrame(new BitmapDrawable(context.getResources(), sprite[i]), 250);
        }

        return animationDrawable;
    }

    /**sh_bat.png : 128*16 => Sprite 2 frames**/
    public static Bitmap[] createBatSprite(Context context, int width, int height, @Nullable Paint paint){
        Bitmap sheet = getBitmapFromAsset(context, "sh_bat.png");

        Rect[] src = new Rect[2];

        for(int i=0;i<2;i++)
            src[i] = new Rect(i*15, 0, (i+1)*15, 16);

        assert sheet != null;
        Bitmap.Config config = sheet.getConfig();

        Canvas canvas = new Canvas();

        Bitmap[] sprite = new Bitmap[2];

        Rect dst = new Rect(0, 0, width, height);

        for(int i=0;i<2;i++){
            sprite[i] = Bitmap.createBitmap(width, height, config);

            canvas.setBitmap(sprite[i]);

            canvas.drawBitmap(sheet, src[i], dst, paint);
        }

        return sprite;
    }

    /**sh_arc.png : 32*32 => Sprite 1 frame**/
    public static Bitmap createBackground(Context context, int width, int height, @Nullable Paint paint){
        Bitmap sheet = getBitmapFromAsset(context, "sh_arc.png");

        assert sheet != null;
        int w = (int)(sheet.getWidth()*2.5);
        int h = sheet.getHeight()*3;

        sheet = multiply(sheet, w, h);

        Rect src = new Rect(0, 0, w, h);

        Rect dst = new Rect(0, 0, width, height);

        Bitmap.Config config = sheet.getConfig();

        Bitmap sprite = Bitmap.createBitmap(width, height, config);

        Canvas canvas = new Canvas();

        canvas.setBitmap(sprite);

        canvas.drawBitmap(sheet, src, dst, paint);

        return sprite;
    }

    /***Create bitmap by decoding asset.***/
    private static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream inputStream;
        Bitmap bitmap;

        try {
            inputStream = assetManager.open(filePath);

            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            return null;
        }

        return bitmap;
    }


    /***Multiply source bitmap to fill target bitmap.***/
    private static Bitmap multiply(Bitmap src, Bitmap dst){	//Repeatedly draw dst to src until dst is completely drawn.
        Canvas c = new Canvas(dst);
        int srcW = src.getWidth(),
                srcH = src.getHeight();

        for(int i=0;i<dst.getHeight();i+=srcH){
            for(int j=0;j<dst.getWidth();j+=srcW)
                c.drawBitmap(src, j, i, null);
        }

        return dst;
    }

    /***Create bitmap by multiplying source bitmap.***/
    private static Bitmap multiply(Bitmap src, int dstWidth, int dstHeight){
        return multiply(src, Bitmap.createBitmap(dstWidth, dstHeight, src.getConfig()));
    }
}
