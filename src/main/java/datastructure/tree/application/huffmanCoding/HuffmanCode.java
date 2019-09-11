package datastructure.tree.application.huffmanCoding;

import java.util.*;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/09/13:52
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String val = "i like like like java do you like a java";
        byte[] bytes = val.getBytes();
        List<Node> nodes = getNodes(bytes);
        Node root = createHuffmanTree(nodes);
        root.preOrder();

        getCodes(root);
        System.out.println(huffmanCodes);

        zip(bytes);
    }


    /**
     * 将byte[]数组转换List<Node>
     *
     * @param bytes
     * @return
     */
    public static List<Node> getNodes(byte[] bytes) {
        //用一个Map来存储每个字符及其对应的出现次数,key为字符，value为对应的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);  //先在map中取(这是一个技巧)
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //将每一个map转化成一个Node对象，并加入到nodes集合
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            String data = entry.getKey().toString();
            Integer count = entry.getValue();
            Node node = new Node(data, count);
            nodes.add(node);
        }

        return nodes;
    }


    /**
     * 根据Node集合创建霍夫曼树
     *
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);

            //构建霍夫曼树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一个新的二叉树，根节点没有data,只有权值
            Node parentNode = new Node(null, leftNode.getCount() + rightNode.getCount());
            parentNode.setLeftNode(leftNode);
            parentNode.setRightNode(rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将新的二叉树，加入到nodes
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    /**
     * 生成霍夫曼编码和编码后的数据
     * 以Map<Byte,String>来存储霍夫曼编码表,key表示字符，String表示对应的编码
     *
     * @param node          霍夫曼树的根节点
     * @param code          路径：左子节点为0，右子节点为1
     * @param stringBuilder 用于拼接路径
     */
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<String, String> huffmanCodes = new HashMap<>();

    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);

        if (node != null) {
            if (node.getData() == null) { //非叶子节点,进行递归处理
                getCodes(node.getLeftNode(), "0", stringBuilder1);
                getCodes(node.getRightNode(), "1", stringBuilder1);
            } else {
                huffmanCodes.put(node.getData(), stringBuilder1.toString());
            }
        }
    }

    //为了方便调用，对上面方法进行重载
    public static Map<String, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.getLeftNode(), "0", stringBuilder);
        getCodes(root.getRightNode(), "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将一个byte[]数组转化成霍夫曼编码压缩后的byte[]
     */
    public static void zip(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {

        }
        System.out.println("测试：" + stringBuilder.toString());
    }
}
