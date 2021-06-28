package datastructure.josephu;

import datastructure.josephu.singlyCirLinkList.CircleLinkList;
import datastructure.josephu.singlyCirLinkList.SCLinkList;
import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/22:11
 */
public class Test03 {
    public static void main(String[] args) {
        SCLinkList scLinkList = new SCLinkList();
        scLinkList.add(5);
        scLinkList.showPerson();
        System.out.println("小孩出圈顺序=========");
        scLinkList.solve(1, 2, 10);
    }

    @Test
    public void test01(){
        CircleLinkList cl = new CircleLinkList();
        cl.creatLinkList(3);

    }
}
