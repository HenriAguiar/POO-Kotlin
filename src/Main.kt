// =============================================================================
// PONTO DE ENTRADA — Orquestração
// =============================================================================
// O main() é responsável apenas por montar as peças e iniciar o programa.
// Ele não contém lógica de negócio nem de formatação — delega tudo para as
// classes adequadas. Isso mantém o main() curto e de fácil leitura.
// =============================================================================

fun main() {

    // -------------------------------------------------------------------------
    // INSTANCIAÇÃO DE OBJETOS
    // -------------------------------------------------------------------------
    // Cada `val` cria um objeto concreto na memória (heap).
    // Em Kotlin, `val` declara uma referência imutável — a variável não pode
    // apontar para outro objeto depois de atribuída (mas o objeto em si pode
    // ter estado mutável, se usar `var` internamente).
    //
    // Os argumentos nomeados (`nome = "..."`) são um recurso do Kotlin que
    // torna a instanciação legível e independente da ordem dos parâmetros.
    // -------------------------------------------------------------------------

    // Gerente: bônus de 20% calculado polimorficamente
    val ana = Gerente(
        nome = "Ana Lima",
        salarioBase = 8_000.0,
        departamento = "Tecnologia"
    )

    // Gerente: `_` nos literais numéricos melhora a legibilidade (9_500 = 9500)
    val bruno = Gerente(
        nome = "Bruno Saraiva",
        salarioBase = 9_500.0,
        departamento = "Operações"
    )

    // -------------------------------------------------------------------------
    // NULL SAFETY — departamento = null (obrigatório pelo enunciado)
    // -------------------------------------------------------------------------
    // Carlos não tem departamento atribuído. Em Kotlin, isso só é possível
    // porque `departamento` foi declarado como `String?` (nullable).
    // Se tentássemos passar null para um campo `String` (não nullable),
    // o compilador rejeitaria — o erro acontece em tempo de compilação,
    // não em tempo de execução como no Java.
    //
    // O tratamento desse null acontece em RelatorioService com o operador Elvis.
    // -------------------------------------------------------------------------
    val carlos = Desenvolvedor(
        nome = "Carlos Nunes",
        salarioBase = 6_500.0,
        departamento = null
    )

    // Desenvolvedor: bônus de 10% calculado polimorficamente
    val diana = Desenvolvedor(
        nome = "Diana Ferreira",
        salarioBase = 7_200.0,
        departamento = "Produto"
    )

    val eduardo = Gerente(
        nome = "Eduardo Costa",
        salarioBase = 11_000.0,
        departamento = "Financeiro"
    )

    // -------------------------------------------------------------------------
    // FIRST-CLASS COLLECTION — a lista entra na Equipe e nunca fica exposta
    // -------------------------------------------------------------------------
    // `listOf(...)` cria uma lista imutável. Passamos objetos de tipos diferentes
    // (Gerente e Desenvolvedor), mas todos são compatíveis com `List<Funcionario>`
    // porque ambos herdam de Funcionario — isso é o princípio da substituição
    // de Liskov (LSP): subtipos podem ser usados onde o supertipo é esperado.
    // -------------------------------------------------------------------------
    val equipe = Equipe(listOf(ana, bruno, carlos, diana, eduardo))

    // -------------------------------------------------------------------------
    // DELEGAÇÃO — main() não sabe como o relatório é formatado
    // -------------------------------------------------------------------------
    // Toda lógica de exibição está em RelatorioService (SRP).
    // O main() apenas diz "gere o relatório desta equipe" — sem saber os detalhes.
    // -------------------------------------------------------------------------
    RelatorioService().imprimirRelatorio(equipe)
}
