package com.example.viajabessa

class Pacotes (
    nome: String? = null,
    valor: Float? = null,
    id: Long? = null,
    var descricao: String? = null,
): PacotesLite(nome, valor){
    override fun toString(): String = "$nome: $valor"
}