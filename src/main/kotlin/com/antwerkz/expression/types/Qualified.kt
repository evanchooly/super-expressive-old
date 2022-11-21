package com.antwerkz.expression.types

abstract class Qualified(type: String) : Type(type) {
    init {
        containsChildren = true
    }
    fun evaluate(symbol: String): String {
        val value = this.value as Type
        val inner = value.evaluate()
        val withGroup = if (value.quantifierRequiresGroup) "(?:${inner})" else inner

        return "${withGroup}$symbol"
    }
}
