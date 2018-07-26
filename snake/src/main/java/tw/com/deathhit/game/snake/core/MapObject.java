package tw.com.deathhit.game.snake.core;

import android.os.Message;

public interface MapObject{
    Message onContact(SnakeGameController controller);
}
