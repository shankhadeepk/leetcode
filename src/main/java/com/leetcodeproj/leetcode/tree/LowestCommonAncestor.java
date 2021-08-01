package com.leetcodeproj.leetcode.tree;
/*
*
* 236. Lowest Common Ancestor of a Binary Tree
*
* 1.
*
* */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(left==null && right==null) return null;

        return left!=null?left:right;
    }

    private TreeNode createTree(Integer[] arr){
        TreeNode root=null;

        root=new TreeNode(arr[0]);
        root.left=new TreeNode(arr[1]);
        root.right=new TreeNode(arr[2]);
        root.left.left=new TreeNode(arr[3]);
        root.left.right=new TreeNode(arr[4]);
        root.right.left=new TreeNode(arr[5]);
        root.right.right=new TreeNode(arr[6]);
        root.left.left.left=null;
        root.left.left.right=null;
        root.left.right.left=new TreeNode(arr[9]);
        root.left.right.right=new TreeNode(arr[10]);
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr={3,5,1,6,2,0,8,null,null,7,4};
        LowestCommonAncestor lca=new LowestCommonAncestor();
        System.out.println(lca.lowestCommonAncestor(lca.createTree(arr),new TreeNode(5),new TreeNode(1)));
    }
}
