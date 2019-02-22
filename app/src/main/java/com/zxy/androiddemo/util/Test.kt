package com.zxy.androiddemo.util

import kotlin.reflect.KProperty

class Example{
    var p:String by Delegate()
}

class Delegate{
    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        return "${property.name}"
    }

    operator fun setValue(thisRef:Any?,property:KProperty<*>,value:String){
        print(property.name)
    }
}

fun main(args: Array<String>) {
    val e = Example()
    print(e.p)
}