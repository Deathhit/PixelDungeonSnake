package tw.com.deathhit.game.snake.core;

import android.support.annotation.Nullable;
import android.util.SparseArray;

public class Map {
    private final SparseArray<MapObject> objects;

    private final int height;
    private final int width;

    public Map(int width, int height){
        objects = new SparseArray<>(width*height);

        this.height = height;
        this.width = width;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("{");

        for(int i=0;i<objects.size();i++){
            int key = objects.keyAt(i);

            result.append("(").append(key%width).append(",").append(key/width).append(",").append(objects.valueAt(i).getClass().getSimpleName()).append(")");
        }

        return result.append("}").toString();
    }

    @Nullable
    public MapObject get(int x, int y){
        return objects.get(getKey(x, y));
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void put(MapObject object, int x, int y){
        objects.put(getKey(x, y), object);
    }

    public void remove(int x, int y){
        objects.remove(getKey(x, y));
    }

    private int getKey(int x, int y){
        return x + y*width;
    }
}
