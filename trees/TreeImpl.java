package trees;

public class TreeImpl
{
  int val;
  TreeImpl left;
  TreeImpl right;

  TreeImpl()
  {
    this.val=0;
    this.left=null;
    this.right=null;
  }
  TreeImpl(int val)
  {
    this.val = val;
    this.left=null;
    this.right=null;
  }
  public TreeImpl createNode(int val)
  {
    TreeImpl treeimpl= new TreeImpl(val);
    return treeimpl;
  }
}
