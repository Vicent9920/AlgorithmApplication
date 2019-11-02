package com.vincent.algorithmapplication.data_structure

import java.util.*

/**
 * <p>文件描述：二叉树通过递归的方式实现的遍历<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/25 0025 <p>
 * <p>@update 2019/10/25 0025<p>
 * <p>版本号：1<p>
 *
 */

// 二叉树实体
data class TreeNode(val data: Int) {
    var leftChild: TreeNode? = null
    var rightChild: TreeNode? = null
}

object TreeSort {
    fun createBinaryTree(inputList: LinkedList<Int?>?): TreeNode? {
        if (inputList == null || inputList.isEmpty()) {
            return null
        }
        var node: TreeNode? = null
        var data = inputList?.removeFirst()
        if (data != null) {
            node = TreeNode(data)
            node.leftChild = createBinaryTree(inputList)
            node.rightChild = createBinaryTree(inputList)
        }
        return node

    }

    // 二叉树前序排列
    fun preOrderTraversal(node: TreeNode?) {
        if (node == null) return
        print(node.data)
        preOrderTraversal(node.leftChild)
        preOrderTraversal(node.rightChild)
    }


    // 二叉树中序排列
    fun inOrderTraversal(node: TreeNode?) {
        if (node == null) return
        inOrderTraversal(node.leftChild)
        print(node.data)
        inOrderTraversal(node.rightChild)
    }


    // 二叉树后序排列
    fun postOrderTraversal(node: TreeNode?) {
        if (node == null) return
        postOrderTraversal(node.leftChild)
        postOrderTraversal(node.rightChild)
        print(node.data)
    }
    // 二叉树层序遍历
    fun levelOrderTraversal(node: TreeNode?){
        val queue = LinkedList<TreeNode>()
        queue.offer(node)
        while (queue.isEmpty().not()){
            val itemTreeNode = queue.poll()
            print(itemTreeNode.data)
            if(itemTreeNode.leftChild != null){
                queue.offer(itemTreeNode.leftChild)
            }
            if(itemTreeNode.rightChild != null){
                queue.offer(itemTreeNode.rightChild)
            }
        }

    }

    // 二叉树前序排列 栈
    fun preOrderTraversalWithStack(node: TreeNode?) {
        val stack = Stack<TreeNode>()
        var root = node
        while (root != null || stack.isEmpty().not()) {
            while (root != null) {
                print(root.data)
                stack.push(root)
                root = root.leftChild
            }
            while (stack.empty().not()) {
                root = stack.pop()
                root = root.rightChild
                if (root != null) {
                    break
                }
            }
        }
    }
    // 二叉树中序排列 栈
    fun inOrderTraversalWithStack(node: TreeNode?) {
        val stack = Stack<TreeNode>()
        var root = node
        while (root != null || stack.isEmpty().not()) {
            while (root != null) {
                stack.push(root)
                root = root.leftChild
            }
            while (stack.empty().not()) {
                root = stack.pop()
                print(root.data)
                root = root.rightChild
                if (root != null) {
                    break
                }
            }
        }
    }

    // 二叉树后序排列 栈
    fun postOrderTraversalWithStack(node: TreeNode?) {
        val stack = Stack<TreeNode>()
        var root = node
        while (root != null || stack.isEmpty().not()) {
            while (root != null) {
                stack.push(root)
                root = root.leftChild
            }
            while (stack.empty().not()) {
                root = stack.pop()
                if (root?.rightChild != null) {
                    val parent = TreeNode(root.data)
                    stack.push(parent)
                    root = root.rightChild
                    break
                } else {
                    print(root.data)
                    root = null
                }
            }
        }
    }
}