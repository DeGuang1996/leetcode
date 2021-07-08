package string;

import java.util.*;

public class DisplayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foods = new TreeSet<>();
        TreeSet<Integer> tables = new TreeSet<>();
        HashMap<Integer, HashMap<String, Integer>> menu = new HashMap<>();

        for (List<String> order : orders) {
            String customer = order.get(0);
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            HashMap<String, Integer> subMenu = menu.getOrDefault(table, new HashMap<>());
            subMenu.put(food, subMenu.getOrDefault(food, 0) + 1);
            menu.put(table, subMenu);

            foods.add(food);
            tables.add(table);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foods);
        res.add(title);

        for (Integer table : tables) {
            HashMap<String, Integer> subMenu = menu.get(table);
            List<String> count = new ArrayList<>();
            count.add(String.valueOf(table));
            for (String food : foods) {
                count.add(String.valueOf(subMenu.getOrDefault(food, 0)));
            }
            res.add(count);
        }
        return res;
    }
}
