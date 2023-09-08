enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nomeUsuario: String, val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun desmatricular(usuario: Usuario){
        inscritos.remove(usuario)
    }
}

fun main() {

    // Simular a criação de usuarios
    val usuario1 = Usuario("Marcos", 123)
    val usuario2 = Usuario("Vinicius", 254)
    val usuario3 = Usuario("Alves", 476)

    // Simular a criação de conteudo educacional
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30)
    val conteudo2 = ConteudoEducacional("Avançando no Kotlin", 90)
    val conteudo3 = ConteudoEducacional("Utilizando Kotlin no desenvolvimento Android", 60)
    val conteudo4 = ConteudoEducacional("Jetpack completo", 180)
    val conteudo5 = ConteudoEducacional("Android Studio Completo", 30)

    // Simular a criação de uma formação
    val formacaoKotlin = Formacao("Kotlin em aplicaçãos Android", listOf(conteudo1, conteudo2, conteudo3), Nivel.INTERMEDIARIO)
    val formacaoJetpack = Formacao("Avançando no desenvolvimento Android com Jetpack", listOf(conteudo4, conteudo5), Nivel.AVANCADO)
    
    // Simular a matricula dos usuarios em alguma trilha de formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoJetpack.matricular(usuario3)

    // Simular exibição da lista usuarios matriculados
    // O it é uma variável especial que representa cada elemento individual da lista enquanto a função map itera sobre ela.
    // Neste caso, it refere-se a cada objeto Usuario na lista formacaoKotlin.inscritosos 
    // por isso achei melhor renomear a propriedade para ficar mais legível
    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nomeUsuario }}")
    println("Inscritos na formação ${formacaoJetpack.nome}: ${formacaoJetpack.inscritos.map { it.nomeUsuario }}")
    
    // Simular o cancelamento da matrícula
    formacaoKotlin.desmatricular(usuario2)
    formacaoJetpack.matricular(usuario2)
    println("")
    println("Lista de inscritos atualizadas após cancelamento/mudança de curso:")

    // Simular exibição da lista de usuarios após cancelamento de matrícula
    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nomeUsuario }}")
    println("Inscritos na formação ${formacaoJetpack.nome}: ${formacaoJetpack.inscritos.map { it.nomeUsuario }}")
}