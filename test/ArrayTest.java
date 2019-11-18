import com.coolslow.datastruct.MyArrayList;
import com.coolslow.utils.MyUtils;

public class ArrayTest {

    public static void test() {

        MyArrayList<String> arrayList = new MyArrayList<>();

        MyUtils.startTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }
        MyUtils.endTime("add 10000 times");

        arrayList.add(1, "a");
        MyUtils.endTime("add 1 times");
        arrayList.remove(1);
        MyUtils.endTime("remove 1 times");

        for (int i = 0; i < arrayList.size(); i++) {
            MyUtils.print(arrayList.get(i) + " , ");
        }

        MyUtils.endTime("foreach 10000 times");

    }


}
