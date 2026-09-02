import java.util.*;

class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Graph
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            graph.get(a).add(new Pair(b, value));

            // b / a = 1 / value
            graph.get(b).add(new Pair(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            }
            else if (start.equals(end)) {
                answer[i] = 1.0;
            }
            else {
                Set<String> visited = new HashSet<>();

                answer[i] = dfs(
                        start,
                        end,
                        1.0,
                        graph,
                        visited
                );
            }
        }

        return answer;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Pair>> graph,
            Set<String> visited) {

        // Target found
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Pair edge : graph.get(current)) {

            if (visited.contains(edge.node)) {
                continue;
            }

            double result = dfs(
                    edge.node,
                    target,
                    product * edge.value,
                    graph,
                    visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }

    class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}