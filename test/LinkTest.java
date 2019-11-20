import com.coolslow.datastruct.MyDoubleLinkedList;
import com.coolslow.datastruct.MySingleLinkedList;
import com.coolslow.utils.MyUtils;

public class LinkTest {

    public static void test1() {

        MyUtils.printStartLine();

        MyDoubleLinkedList<String> linkedList = new MyDoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(String.valueOf(i));
        }
        foreach1(linkedList);
        linkedList.remove(8);
        foreach1(linkedList);
        MyUtils.printEndLine();
    }

    public static void test2() {

        MyUtils.printStartLine();

        MySingleLinkedList<String> linkedList = new MySingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(String.valueOf(i));
        }
        foreach2(linkedList);

        MyUtils.printEndLine();
    }


    public static void foreach1(MyDoubleLinkedList<String> linkedList) {
        linkedList.iterator(s -> MyUtils.print(s + " , "));
        MyUtils.printLine();
    }

    public static void foreach2(MySingleLinkedList<String> linkedList) {
        linkedList.iterator(s -> MyUtils.print(s + " , "));
        MyUtils.printLine();
    }


}
