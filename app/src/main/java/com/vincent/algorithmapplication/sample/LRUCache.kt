package com.vincent.algorithmapplication.sample

/**
 * <p>文件描述：LRU 缓存<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/14 0014 <p>
 * <p>@update 2019/11/14 0014<p>
 * <p>版本号：1<p>
 *
 */
class LRUCache(private val limit:Int) {
    private val hashMap = LinkedHashMap<Int,String>()
    private var count = 0
    fun putValue(key:Int,value:String){
        if(count == limit){
            hashMap.keys.remove(hashMap.keys.first())
            count--
        }
        hashMap[key] = value
        count++
    }

    fun getValue(key: Int):String{
        val value = hashMap[key]?:""
        hashMap.keys.remove(key)
        hashMap[key] = value
        return value
    }

    override fun toString(): String {
        return hashMap.toString()
    }
}