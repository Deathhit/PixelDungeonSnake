package tw.com.deathhit.game.snake;

import android.os.Message;

import tw.com.deathhit.game.snake.core.Map;
import tw.com.deathhit.game.snake.core.MapObject;
import tw.com.deathhit.game.snake.core.SnakeGameController;
import tw.com.deathhit.game.snake.core.SnakeGameModel;
import tw.com.deathhit.game.snake.core.SnakeSegment;

public class Food implements MapObject {
    @Override
    public Message onContact(SnakeGameController controller) {
        SnakeGameModel model = controller.getModel();

        SnakeSegment last = model.getSegment(model.getSnakeSize()-1);

        model.snakeMove(controller.getNextX(), controller.getNextY());

        model.snakeConcat(new SimpleSnakeSegment(), last.x, last.y);

        Message message = Message.obtain();

        message.what = Constants.MESSAGE_EAT;

        return message;
    }
}
