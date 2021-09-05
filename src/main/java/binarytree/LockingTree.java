package binarytree;

import java.util.ArrayList;

class LockingTree {

    private Tree[] trees;

    class Tree {
        int cur;
        int parent;
        ArrayList<Tree> children = new ArrayList<>();
        boolean isLock = false;
        int lockUSer = -1;
    }

    public LockingTree(int[] parent) {
        trees = new Tree[parent.length];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
        }
        for (int i = 0; i < parent.length; i++) {
            Tree tree = trees[i];
            tree.cur = i;
            tree.parent = parent[i];
            if (tree.parent != -1) {
                trees[tree.parent].children.add(tree);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (trees[num].isLock) {
            return false;
        }
        trees[num].isLock = true;
        trees[num].lockUSer = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (trees[num].isLock && trees[num].lockUSer == user) {
            trees[num].isLock = false;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (trees[num].isLock) {
            return false;
        }
        Tree tree = trees[num];
        while (tree.parent != -1) {
            tree = trees[tree.parent];
            if (tree.isLock) {
                return false;
            }
        }
        if (unLockDownward(num)) {
            trees[num].isLock = true;
            trees[num].lockUSer = user;
            return true;
        }
        return false;
    }

    private boolean unLockDownward(int num) {
        boolean ans = false;
        ArrayList<Tree> children = trees[num].children;
        for (int i = 0; i < children.size(); i++) {
            if (unLockDownward(children.get(i).cur)) {
                ans = true;
            }
        }
        if (trees[num].isLock) {
            trees[num].isLock = false;
            return true;
        }
        return ans;
    }
}
