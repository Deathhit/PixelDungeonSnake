package tw.com.deathhit.game.snake;

import android.os.Message;

import tw.com.deathhit.game.snake.core.MapObject;
import tw.com.deathhit.game.snake.core.SnakeGameController;

public class Wall implements MapObject {
    @Override
    public Message onContact(SnakeGameController controller) {
        controller.setRunning(false);

        Message message = Message.obtain();

        message.what = Constants.MESSAGE_DIE;

        return message;
    }
}
