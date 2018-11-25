package cbu527;

public class SumInLeavesVisitor extends TreeVis {
    long sum = 0;

    public int getResult() {
        return (int) sum;

    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}