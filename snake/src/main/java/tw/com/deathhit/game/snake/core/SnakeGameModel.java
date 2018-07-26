package tw.com.deathhit.game.snake.core;

import java.util.LinkedList;

public class SnakeGameModel {
    private final Map map;

    private final LinkedList<SnakeSegment> segments = new LinkedList<>();

    public SnakeGameModel(Map map, SnakeSegment head, int x, int y){
        this.map = map;

        segments.add(head);

        head.set(x, y);

        map.put(head, x, y);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for(SnakeSegment segment : segments)
            result.append("(").append(segment.x).append(",").append(segment.y).append(")");

        return result.append("}").toString();
    }

    public void snakeConcat(SnakeSegment segment, int x, int y){
        segment.set(x, y);

        segments.add(segment);

        map.put(segment, x, y);
    }
    
    public SnakeSegment getSegment(int index){
        return segments.get(index);
    }

    public Map getMap() {
        return map;
    }

    public int getSnakeSize(){
        return segments.size();
    }

    public void snakeMove(int x, int y){
        for(SnakeSegment segment : segments){
            int tempX = segment.x;
            int tempY = segment.y;

            segment.set(x, y);

            map.put(segment, x, y);

            x = tempX;
            y = tempY;
        }

        map.remove(x, y);
    }
}
