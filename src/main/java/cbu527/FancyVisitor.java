package cbu527;

public class FancyVisitor extends TreeVis {
    long evenSum = 0;
    long greenSum = 0;

    public int getResult() {

        return (int) Math.abs(evenSum - greenSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenSum += leaf.getValue();
        }
    }
}