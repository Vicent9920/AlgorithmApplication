package com.vincent.algorithmapplication.sample

import kotlin.random.Random

/**
 * <p>文件描述：红包算法实现类<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/14 0014 <p>
 * <p>@update 2019/11/14 0014<p>
 * <p>版本号：1<p>
 *
 */
object Money {
    // 发送红包
    // count 红包个数 money 红包金额
    fun sendMoney(count:Int,money:Int):MutableList<String>{
        // 元一分
        val calculateMoney = money*100
        val result = mutableListOf<String>()
        val rl_lines = IntArray(count-1)
        var ral = 0
        for (i in 0 until count-1){
            rl_lines[i] = Random.nextInt(calculateMoney-ral-(count-i))+1
            ral += rl_lines[i]
        }
        result.add("红包金额${String.format("%.2f",(calculateMoney.toDouble()-ral)/100)}")
        for (i in rl_lines){
            result.add("红包金额${String.format("%.2f", i.toDouble()/100)}")
        }
        return result
    }
}