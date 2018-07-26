package tw.com.deathhit.pixel_dungeon_snake;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.IOException;
import java.io.InputStream;

public class SpriteFactory {
    /**sh_blacksmith.png : 64*16 => Sprite 4 frames**/
    public static Sprite buildBlackSmith(Context context){
        Bitmap sheet = getBitmapFromAsset(context, "sh_blacksmith.png");

        Rect[] locations = new Rect[4];

        for(int i=0;i<4;i++)
            locations[i] = new Rect(i*13, 0, (i+1)*13, 16);

        assert sheet != null;
        return new Sprite(sheet, locations);
    }

    /**sh_blacksmith.png : 128*16 => Sprite 2 frames**/
    public static Sprite buildBat(Context context){
        Bitmap sheet = getBitmapFromAsset(context, "sh_bat.png");

        Rect[] locations = new Rect[2];

        for(int i=0;i<2;i++)
            locations[i] = new Rect(i*15, 0, (i+1)*15, 16);

        assert sheet != null;
        return new Sprite(sheet, locations);
    }

    /**sh_arc.png : 32*32 => Sprite 1 frame**/
    public static Sprite buildArc(Context context){
        Bitmap sheet = getBitmapFromAsset(context, "sh_arc.png");

        assert sheet != null;
        int width = (int)(sheet.getWidth()*2.5);
        int height = sheet.getHeight();

        sheet = multiply(sheet, width, height);

        Rect[] locations = new Rect[1];

        locations[0] = new Rect(0, 0, width, height);

        return new Sprite(sheet, locations);
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
