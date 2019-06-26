package DataStructure;

public class BinarySearchTree {

  TreeNode root = null;

  public void insert(int value) {
    root = insert_r(root, value);
  }

  public void remove(int value) {
    root = remove_r(root, value);
  }

  public int getMin() throws Exception {
    if (root == null) {
      throw new Exception("Empty Binary Search Tree!");
    }
    return getMin_r(root).value;
  }

  public int getMax() throws Exception {
    if (root == null) {
      throw new Exception("Empty Binary Search Tree!");
    }
    return getMax_r(root).value;
  }

  private TreeNode insert_r(TreeNode root, int value) {
    if (root == null) {
      root = new TreeNode(value);
    } else {
      if (value < root.value) {
        root.left = insert_r(root.left, value);
      } else if (value > root.value) {
        root.right = insert_r(root.right, value);
      }
    }
    return root;
  }

  private TreeNode remove_r(TreeNode root, int value) {
    if (root == null) {
      return null;
    } else {
      if (value < root.value) {
        root.left = remove_r(root.left, value);
      } else if (value > root.value) {
        root.right = remove_r(root.right, value);
      } else {
        // This is the node to be removed
        // Case 1: node with only 1 child or no child at all
        if (root.left == null) {
          return root.right;
        } else if (root.right == null) {
          return root.left;
        }

        // Case 2: node with 2 children
        // Replace with min of right subtree
        root.value = getMin_r(root.right).value;
        root.right = remove_r(root.right, root.value);
      }
    }
    return root;
  }

  private TreeNode getMin_r(TreeNode root) {
    if (root.left == null) {
      return root;
    }

    return getMin_r(root.left);
  }

  private TreeNode getMax_r(TreeNode root) {
    if (root.right == null) {
      return root;
    }

    return getMax_r(root.right);
  }

  class TreeNode {

    int value;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int value) {
      this.value = value;
    }
  }
}
