package com.vincent.algorithmapplication

import com.vincent.algorithmapplication.data_structure.BinaryHeap
import com.vincent.algorithmapplication.data_structure.MyQueue
import com.vincent.algorithmapplication.data_structure.PriorityQueue
import com.vincent.algorithmapplication.data_structure.Test
import com.vincent.algorithmapplication.data_structure.TreeSort
import java.util.*

/**
 * <p>文件描述：数据结构测试<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/17 0017 <p>
 * <p>@update 2019/10/17 0017<p>
 * <p>版本号：1<p>
 *
 */
class DataStructure {
    @org.junit.Test
    fun testLinkedList() {
        val test = Test()
        test.insert(3, 0)
        test.outPut()
        println()
        test.insert(7, 1)
        test.outPut()
        println()
        test.insert(9, 2)
        test.insert(5, 3)
        test.outPut()
        println()
        test.insert(4, 2)
        test.outPut()
        println()
        test.remove(0)
        test.outPut()
    }

    @org.junit.Test
    fun testMyQueue() {
        val myQueue = MyQueue(6)
        myQueue.enQueue(3)
        myQueue.enQueue(6)
        myQueue.enQueue(2)
        myQueue.enQueue(7)
        myQueue.enQueue(5)
        myQueue.deQueue()
        myQueue.enQueue(9)
        myQueue.deQueue()
        myQueue.enQueue(4)
        myQueue.deQueue()
        myQueue.enQueue(1)
        myQueue.output()
    }

    @org.junit.Test
    fun sortTreeNode() {

        val inputList = LinkedList<Int?>()
        inputList.addAll(arrayListOf(1, 3, 9, null, null, 5, null, null, 7, null, 8))
        val treeNode =
            TreeSort.createBinaryTree(inputList)
        println("前序排列")
        TreeSort.preOrderTraversal(treeNode)
        println()
        println("前序排列 栈")
        TreeSort.preOrderTraversalWithStack(treeNode)
        println()
        println("中序排列")
        TreeSort.inOrderTraversal(treeNode)
        println()
        println("中序排列 栈")
        TreeSort.inOrderTraversalWithStack(treeNode)
        println()
        println("后续排列")
        TreeSort.postOrderTraversal(treeNode)
        println()
        println("后序排列 栈")
        TreeSort.postOrderTraversalWithStack(
            treeNode
        )
        println()
        println("层序遍历")
        TreeSort.levelOrderTraversal(treeNode)
    }

    @org.junit.Test
    fun testBinaryHeap(){
        var array = intArrayOf(1,2,3,4,5,6,7,8,9,0)
        BinaryHeap.upAdjust(array)
        println(array.contentToString())

        array = intArrayOf(7,1,3,10,5,2,8,9,6)
        BinaryHeap.buildHeap(array)
        println(array.contentToString())

    }
    @org.junit.Test
    fun testPriorityQueue(){
        val priorityQueue = PriorityQueue()
        priorityQueue.enQueue(3)
        priorityQueue.enQueue(5)
        priorityQueue.enQueue(10)
        priorityQueue.enQueue(2)
        priorityQueue.enQueue(7)
        println(priorityQueue.deQueue())
        println(priorityQueue.deQueue())
    }
}