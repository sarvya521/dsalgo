package ds.graph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    private static final String COMPONENT_NAME = "ThreadingUtility"; // NOI18N

    /**
     * Separator for item label key in Bundle.
     */
    private static final String ITEM_SEPARATOR = ".property."; // NOI18N

    private List workQueueItemList;

    private static String getItemLabel(final String property, final String item) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(COMPONENT_NAME);
        buffer.append(ITEM_SEPARATOR);
        buffer.append(property);
        buffer.append("."); // NOI18N
        buffer.append(item);
        return buffer.toString();
    }

    public List<String> getWorkQueueComboItems() {
        if (workQueueItemList == null) {
            String[] items = new String[]{"delayQueue", "linkedBlockingDeque",
                    "linkedBlockingQueue", "priorityBlockingQueue", "synchronousQueue"}; // NOI18N
            workQueueItemList = Arrays.stream(items).map(item -> getItemLabel("workQueue", item)).collect(Collectors.toList());
        }
        return workQueueItemList;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getWorkQueueComboItems());
    }
}
