package src.estoque

import src.item.Item

class Estoque {
    private var codigo = 0
    private var nomeItem = ""
    private var preco = 0.0
    private val listaItem = mutableSetOf<Item>()

    fun registrarItem(): Item {
        codigo = verificarItemRepetido(listaItem)
        println("Digite o nome do produto: ")
        nomeItem = readln()
        println("Digite o preço do produto: ")
        while (true) {
            try {
                preco = readln().toDouble()
                break
            } catch (exception: Exception) {
                println(exception.message)
                println("Digite um número")
            }
        }
        val item = Item(codigo = codigo, nome = nomeItem, preco = preco)
        listaItem.add(item)
        println("Item registrado com sucesso\n")
        return item
    }

    fun verificarItemRepetido(lista: MutableSet<Item>): Int {
        while (true) {
            try {
                println("Digite o código do produto: ")
                codigo = readln().toInt()
                lista.forEach {
                    while (it.codigo == codigo) {
                        println("Código já usado, digite um novo código:")
                        codigo = readln().toInt()
                    }
                }
                break
            } catch (exception: Exception) {
                println(exception.message)
                println("Digite um número")
            }
        }
        return codigo
    }

    fun listarItens() {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento")
        } else {
            println("Atualmente temos os seguintes itens: $listaItem");
        }
    }

    fun darBaixaItem() {
        var codigoItemADarBaixa: Int
        while (true) {
            try {
                print("Qual o código do item a dar baixa? ")
                codigoItemADarBaixa = readln().toInt()
                break
            } catch (exception: Exception) {
                println(exception.message)
                println("Digite um número")
            }
        }
        for (item in listaItem) {
            if (codigoItemADarBaixa == item.codigo) {
                listaItem.remove(item)
                println("Item removido com sucesso")
                break
            }
        }
    }
}