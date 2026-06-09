import java.util.*;

class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);

        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);

        map.put(lastElement, index);

        list.remove(list.size() - 1);

        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }
}