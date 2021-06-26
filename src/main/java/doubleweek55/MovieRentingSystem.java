package doubleweek55;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class MovieRentingSystem {

    class MovieShop implements Comparable<MovieShop> {

        public int shop;
        public int price;

        public MovieShop(int shop, int price) {
            this.shop = shop;
            this.price = price;
        }

        @Override
        public int compareTo(MovieShop movieShop) {
            if (movieShop.price == this.price) {
                return this.shop - movieShop.shop;
            }
            return this.price - movieShop.price;
        }
    }

    class MovieSold implements Comparable<MovieSold> {

        public int movie;
        public int shop;
        public int price;

        public MovieSold(int movie, int shop, int price) {
            this.movie = movie;
            this.shop = shop;
            this.price = price;
        }

        @Override
        public int compareTo(MovieSold movieSold) {
            if (movieSold.price == this.price) {
                if (this.movie == movieSold.movie) {
                    return this.shop - movieSold.shop;
                }
                return this.movie - movieSold.movie;
            }
            return this.price - movieSold.price;
        }
    }

    private HashMap<Integer, TreeSet<MovieShop>> sortMovies = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> totalMovies = new HashMap<>();
    private TreeSet<MovieSold> soldSortMovies = new TreeSet<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int i = 0; i < entries.length; i++) {
            MovieShop movieShop = new MovieShop(entries[i][0], entries[i][2]);
            TreeSet<MovieShop> treeSet = sortMovies.getOrDefault(entries[i][1], new TreeSet<>());
            treeSet.add(movieShop);
            sortMovies.put(entries[i][1], treeSet);

            HashMap<Integer, Integer> movies = totalMovies.getOrDefault(entries[i][1], new HashMap<>());
            movies.put(entries[i][0], entries[i][2]);
            totalMovies.put(entries[i][1], movies);
        }
    }

    public List<Integer> search(int movie) {
        if (sortMovies.containsKey(movie)) {
            TreeSet<MovieShop> treeSet = sortMovies.get(movie);
            int count = 0;
            List<Integer> res = new ArrayList<>();
            for (MovieShop movieShop : treeSet) {
                res.add(movieShop.shop);
                count++;
                if (count >= 5) {
                    break;
                }
            }
            return res;
        }
        return new ArrayList<>();
    }

    public void rent(int shop, int movie) {
        int price = totalMovies.get(movie).get(shop);
        MovieShop movieShop = new MovieShop(shop, price);

        sortMovies.get(movie).remove(movieShop);
        if (sortMovies.get(movie).isEmpty()) {
            sortMovies.remove(movie);
        }

        MovieSold movieSold = new MovieSold(movie, shop, price);
        soldSortMovies.add(movieSold);
    }

    public void drop(int shop, int movie) {
        int price = totalMovies.get(movie).get(shop);
        MovieShop movieShop = new MovieShop(shop, price);

        TreeSet<MovieShop> treeSet = sortMovies.getOrDefault(movie, new TreeSet<>());
        treeSet.add(movieShop);
        sortMovies.put(movie, treeSet);

        MovieSold movieSold = new MovieSold(movie, shop, price);
        soldSortMovies.remove(movieSold);
    }

    public List<List<Integer>> report() {
        int count = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (MovieSold movieSold : soldSortMovies) {
            List<Integer> temp = new ArrayList<>();
            temp.add(movieSold.shop);
            temp.add(movieSold.movie);
            res.add(temp);
            count++;
            if (count >= 5) {
                break;
            }
        }
        return res;
    }
}
