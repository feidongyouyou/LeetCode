package Contest_86;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2018/5/27.
 */
public class KeysandRooms_841 {
    public static HashSet<Integer> open;
    public static HashMap<Integer, Integer> flag;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        open = new HashSet<>();
        flag = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            flag.put(i, 0);
        }

        search(0, rooms);
        int len = rooms.size();
        for (int i = 1; i < len; i++) {
            if (!open.contains(i)) return false;
        }
        return true;
    }

    public static void search(int n, List<List<Integer>> rooms){
        flag.put(n, 1);
        for (int num : rooms.get(n)) {
            if (flag.get(num) != 1){
                open.add(num);
                search(num, rooms);
            }
        }
    }


}

