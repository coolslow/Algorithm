import com.coolslow.datastruct.MyQueue;
import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyUtils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTest {

    public static void test() throws InterruptedException {

        MyUtils.printStartLine();
        MyUtils.startTime();

        MyQueue<String> queue = new MyQueue<>();
        for (int i = 0; i < 1000; i++) {
            queue.add(String.valueOf(i));
        }
        MyUtils.endTime("queue add 1000 times cost ");
        MyUtils.print(queue.remove()+","+queue.remove()+","+queue.remove()+","+queue.remove());
        MyUtils.printLine();
        foreach(queue);

        MyUtils.endTime("queue foreach cost ");

        MyUtils.printEndLine();

    }


    public static void foreach(MyQueue<String> list) {
        list.iterator(s -> {
            MyUtils.print(s + " , ");
        });
        MyUtils.printLine();
    }


}
