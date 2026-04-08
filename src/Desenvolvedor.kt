// =============================================================================
// HERANÇA + DATA CLASS
// =============================================================================
// Assim como Gerente, Desenvolvedor herda de Funcionario e é um `data class`.
//
// Ambas as classes compartilham a mesma estrutura de propriedades, mas têm
// comportamentos diferentes — isso é o princípio central do polimorfismo:
// objetos de tipos distintos respondem de forma diferente à mesma mensagem
// (`calcularBonus()`), sem que quem chama precise saber o tipo concreto.
//
// Note que não existe herança entre Gerente e Desenvolvedor — eles são
// irmãos na hierarquia, não pai e filho. Ambos herdam apenas de Funcionario.
// =============================================================================

data class Desenvolvedor(
    override val nome: String,
    override val salarioBase: Double,

    // `String?` (nullable) herdado do contrato de Funcionario.
    // O `?` precisa aparecer aqui também para manter a compatibilidade
    // de tipo com a propriedade abstrata da superclasse.
    override val departamento: String?

) : Funcionario() {

    // -------------------------------------------------------------------------
    // POLIMORFISMO — regra diferente, mesmo contrato
    // -------------------------------------------------------------------------
    // Desenvolvedor recebe 10% de bônus. A implementação é diferente da do
    // Gerente, mas a assinatura do método é idêntica. Quem itera a lista de
    // funcionários chama `calcularBonus()` sem distinção — o runtime decide
    // qual implementação executar com base no tipo real do objeto.
    // -------------------------------------------------------------------------
    override fun calcularBonus() = salarioBase * 0.10
}
