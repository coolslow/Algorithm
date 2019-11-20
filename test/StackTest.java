import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyUtils;

import java.util.concurrent.LinkedBlockingQueue;

public class StackTest {

    public static void test() {
        MyUtils.printStartLine();
        MyUtils.startTime();
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < 1000; i++) {
            stack.push(String.valueOf(i));
        }
        stack.pop();
        stack.pop();

        MyUtils.endTime("stack push 1000 times cost ");

        foreach(stack);

        MyUtils.endTime("stack foreach cost ");
        MyUtils.printEndLine();

    }


    public static void foreach(MyStack<String> list) {
        list.iterator(s -> {
            MyUtils.print(s + " , ");
        });
        MyUtils.printLine();
    }


}
