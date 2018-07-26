package tw.com.deathhit.game.snake;

import android.os.Message;

import tw.com.deathhit.game.snake.core.SnakeGameController;
import tw.com.deathhit.game.snake.core.SnakeSegment;

import static tw.com.deathhit.game.snake.Constants.MESSAGE_DIE;

public class SimpleSnakeSegment extends SnakeSegment {
    @Override
    public Message onContact(SnakeGameController controller) {
        controller.setRunning(false);

        Message message = Message.obtain();

        message.what = MESSAGE_DIE;

        return message;
    }
}
