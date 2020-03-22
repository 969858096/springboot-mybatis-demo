package com.lsp.springbootmybatisdemo.test.设计模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: HuffmanTree
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/3/15 15:55
 */
public class HuffmanTree {
    //测试一把
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        preOrder( huffmanTree(arr));
    }

    //前序遍历
    public static void preOrder(Node1 root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空的，无法输出");
        }
    }

    //创建哈夫曼树
    public static Node1 huffmanTree(int[] arr){
        List<Node1> list = new ArrayList<>();
        for (int value:arr) {
            list.add(new Node1(value));
        }

        while (list.size()>1){
            //排序
            Collections.sort(list);

            //取出最小的两个
            Node1 minNode1 = list.get(0);
            Node1 minNode2 = list.get(1);

            //新建一个节点，它的权值等于这两个之和
            Node1 newNode = new Node1(minNode1.getValue()+minNode2.getValue());
            //组成树
            newNode.setLeftNode(minNode1);
            newNode.setRightNode(minNode2);

            //删除最小的两个，将新的节点保存
            list.remove(minNode1);
            list.remove(minNode2);
            list.add(newNode);
        }
        return list.get(0);
    }

}

//创建哈夫曼树的节点
class Node1 implements Comparable<Node1>{
    private int value;
    private Node1 leftNode;
    private Node1 rightNode;

    public Node1(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node1 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node1 leftNode) {
        this.leftNode = leftNode;
    }

    public Node1 getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node1 rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node1 o) {
        return this.value - o.value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.getLeftNode()!=null){
            this.getLeftNode().preOrder();
        }
        if (this.getRightNode()!=null){
            this.getRightNode().preOrder();
        }
    }

}
