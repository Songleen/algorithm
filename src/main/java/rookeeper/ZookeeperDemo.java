package rookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2021/04/12/20:21
 */
public class ZookeeperDemo {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient("myZk");
        zk.createPersistent("abc");
    }
}
