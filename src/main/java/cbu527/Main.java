package cbu527;

import java.util.*;
import java.util.Scanner;


public class Main {

    public static Tree solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ns = new Node[n + 1]; // ignore 0
        for (int i = 1; i < n + 1; i++) {
            ns[i] = new Node();
            ns[i].val = in.nextInt();
        }

        for (int i = 1; i < n + 1; i++) {
            ns[i].col = in.nextInt() == 1 ? Color.GREEN : Color.RED;
        }
        for (int i = 0; i < n - 1; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            ns[from].connections.add(to);
            ns[to].connections.add(from);
        }

        Tree ret = buildNode(1, 0, 0);
        return ret;
    }

    static Tree buildNode(int idx, int depth, int parent) {

        Node n = ns[idx];
        if (n.connections.contains(parent)) {
            n.connections.remove(parent);
        }
        if (n.connections.size() != 0) {
            TreeNode ret = new TreeNode(n.val, n.col, depth);
            for (int i : n.connections) {
                ret.addChild(buildNode(i, depth + 1, idx));
            }
            return ret;
        } else {
            return new TreeLeaf(n.val, n.col, depth);
        }
    }

    static Node[] ns;

    static class Node {
        int val;
        Color col;
        HashSet<Integer> connections = new HashSet<>();

    }
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
