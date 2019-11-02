package com.vincent.algorithmapplication.data_structure

import java.lang.IndexOutOfBoundsException

/**
 * <p>文件描述：链表的基本操作<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/17 0017 <p>
 * <p>@update 2019/10/17 0017<p>
 * <p>版本号：1<p>
 *
 */
// 单链表
data class Node(var data:Int,var next: Node? = null)
// 双链表
data class DoubleNode(var data: Int, var prev: DoubleNode?, var next: DoubleNode?)

class Test {
    // 头节点指针
    private  var head: Node? = null
    // 尾节点指针
    private  var last: Node? = null
    // 链表实际长度
    private var size = 0

    // 插入链表元素
    fun insert(data:Int,index:Int){
        if(index<0 || index>size){
            throw IndexOutOfBoundsException("超出链表节点范围")
        }
        val insertNode = Node(data)
        if(size == 0){
            // 空链表
            head = insertNode
            last = insertNode
        }else if(index == 0){
            // 插入头部
            insertNode.next = head
            head = insertNode
        }else if (size == index){
            // 插入尾部
            last?.next = insertNode
            last = insertNode
        }else{
            // 插入中间
            val prevNode = getNode(index-1)
            insertNode.next = prevNode?.next
            prevNode?.next = insertNode
        }
        size++
    }

    fun remove(index: Int): Node?{
        if(index<0 || index>=size){
            throw IndexOutOfBoundsException("超出链表节点范围")
        }
        var removeNode: Node? = null
        if(index == 0){
            // 删除头节点
            removeNode = head
            head = head?.next
        }else if (index == size-1){
            // 删除尾节点
            removeNode = getNode(index-1)
            removeNode?.next = null
            last = removeNode

        }else {
            // 删除中间节点
            val prevNode = getNode(index-1)
            removeNode = prevNode?.next
            val nextNode = prevNode?.next?.next
            prevNode?.next = nextNode
        }
        size--
        return removeNode
    }
    fun outPut(){
        var  temp = head
        while (temp != null){
            print(temp.data)
            temp = temp.next
        }
    }

    /**
     * 链表查找元素
     */
    private fun getNode(index: Int): Node? {
        if(index<0 || index>=size){
            throw IndexOutOfBoundsException("超出链表节点范围")
        }
        var temp: Node? = head
        for (i in 0 until index){
            temp = temp?.next
        }
        return temp
    }


}