import cbu527.SumInLeavesVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestBinaryTree {


    @Test
    public void TestSumInLeaves(){

        SumInLeavesVisitor add = new SumInLeavesVisitor();
        add.getResult();
        Assertions.assertEquals(12,add.getResult());

        List list = new ArrayList();
        list.add(1);
        list.add(10);
        list.add(20);
        Assertions.assertEquals(3,add.getResult());
    }
}
