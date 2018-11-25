package cbu527;

import java.math.BigInteger;

class ProductOfRedNodesVisitor extends TreeVis {
    BigInteger prod = BigInteger.ONE;

    public int getResult() {
        return prod.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            prod = prod.multiply(BigInteger.valueOf(node.getValue()));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            prod = prod.multiply(BigInteger.valueOf(leaf.getValue()));
        }
    }
}
