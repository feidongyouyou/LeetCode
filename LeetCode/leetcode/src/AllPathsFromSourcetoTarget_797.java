import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/11.
 */
public class AllPathsFromSourcetoTarget_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, result, path);
        return result;
    }

    public static void dfsSearch(int[][] gragh, int node, List<List<Integer>> res, ArrayList<Integer> path){
        if (node == gragh.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : gragh[node]) {
            path.add(nextNode);
            dfsSearch(gragh, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
