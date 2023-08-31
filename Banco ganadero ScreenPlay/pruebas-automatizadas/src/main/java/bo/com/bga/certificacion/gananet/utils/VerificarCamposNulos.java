package bo.com.bga.certificacion.gananet.utils;

import java.util.*;

public class VerificarCamposNulos {
    public static void getCollection(Collection<String> collection) {
        List<String> list = new ArrayList<>(collection);
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item == null || item.equals("-")) {
                int index = iterator.previousIndex();
                iterator.set("");
            }
        }
        collection.clear();
        collection.addAll(list);

    }
}
