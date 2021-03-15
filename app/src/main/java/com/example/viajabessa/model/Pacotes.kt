package com.example.viajabessa.model

class Pacotes (
    var id: Long? = null,
    var nome: String? = null,
    var valor: Float? = null,
    var descricao: String? = null,
    var imageUrl: String? = null,
){
    override fun toString(): String = "$nome: R$:$valor"
}