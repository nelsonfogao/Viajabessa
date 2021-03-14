package com.example.viajabessa

open class PacotesLite (
    var nome:String? = null,
    var valor:Float? = null,
    var id:Long? = null,
){
    override fun toString(): String = "$nome: $valor"
}