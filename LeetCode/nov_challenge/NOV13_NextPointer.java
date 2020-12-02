package LeetCode.nov_challenge;

import java.util.LinkedList;
import java.util.Queue;

// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
class NodeT {
  public int val;
  public NodeT left;
  public NodeT right;
  public NodeT next;

  public NodeT() {}

  public NodeT(int _val) {
    val = _val;
  }

  public NodeT(int _val, NodeT _left, NodeT _right, NodeT _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

class NOV13_NextPointer {
  public static NodeT connect(NodeT root) {
    if(root == null) return null;
    NodeT temp = root;
    Queue<NodeT> even = new LinkedList<>();
    Queue<NodeT> odd = new LinkedList<>();
    even.offer(root);
    while(!even.isEmpty() || !odd.isEmpty())
    {
      if(!even.isEmpty())
      {
        transferNode(even,odd);
      }
      else
      {
        transferNode(odd,even);
      }
    }
    return temp;
  }

  public static void transferNode(Queue<NodeT> curr , Queue<NodeT> transfer)
  {
    if(curr.isEmpty()) return;
    NodeT top = curr.poll();
    if(curr.isEmpty()) top.next=null;
    else top.next=curr.peek();
    if(top.left!=null) transfer.offer(top.left);
    if(top.right!=null) transfer.offer(top.right);
    transferNode(curr,transfer);
  }

  public static void main( String[] args )
  {
    NodeT root = new NodeT(1);
    root.left = new NodeT(2);
    root.right = new NodeT(3);
    root.left.left = new NodeT(4);
    root.left.right = new NodeT(5);
    root.right.left = new NodeT(6);
    root.right.right = new NodeT(7);
    connect( root );
  }
}
