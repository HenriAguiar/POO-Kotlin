// =============================================================================
// SINGLE RESPONSIBILITY PRINCIPLE (SRP)
// =============================================================================
// Uma classe deve ter apenas uma razão para mudar.
//
// RelatorioService existe exclusivamente para formatar e exibir dados.
// As entidades (Gerente, Desenvolvedor) não sabem como são apresentadas —
// elas apenas carregam dados. Isso separa duas responsabilidades distintas:
//   - O QUE é um funcionário  → definido em Funcionario e subclasses
//   - COMO exibir um relatório → definido aqui
//
// Se o formato mudar (ex: gerar PDF em vez de console), só esta classe muda.
// =============================================================================

class RelatorioService {

    // Recebe uma Equipe — depende da abstração, não de um tipo concreto.
    // Isso segue o Dependency Inversion Principle: módulos de alto nível
    // não dependem de detalhes, mas de abstrações.
    fun imprimirRelatorio(equipe: Equipe) {
        println("╔══════════════════════════════════════╗")
        println("║       RELATÓRIO DE FUNCIONÁRIOS       ║")
        println("╚══════════════════════════════════════╝")
        println()

        // Delega a iteração para a Equipe (respeita o encapsulamento da coleção).
        // O lambda `{ imprimirFuncionario(it) }` é executado para cada membro.
        // `it` é o nome implícito do parâmetro em lambdas de argumento único.
        equipe.paraCadaMembro { imprimirFuncionario(it) }
    }

    // `private` — detalhe de implementação, não faz parte da interface pública.
    // Recebe Funcionario (tipo abstrato), não Gerente ou Desenvolvedor —
    // o método não sabe nem precisa saber o tipo concreto de quem chegou.
    private fun imprimirFuncionario(funcionario: Funcionario) {

        // ---------------------------------------------------------------------
        // NULL SAFETY — Operador Elvis (?:)
        // ---------------------------------------------------------------------
        // `funcionario.departamento` pode ser null (tipo String?).
        // O operador `?:` (Elvis) avalia o lado esquerdo e, se for null,
        // usa o valor do lado direito como alternativa.
        //
        //   departamento = "Tecnologia"  →  exibe "Tecnologia"
        //   departamento = null          →  exibe "Não informado"
        //
        // Sem `if`, sem `else` — uma expressão concisa que o compilador garante
        // que cobre o caso nulo. Nunca há risco de NullPointerException aqui.
        // ---------------------------------------------------------------------
        val departamentoExibido = funcionario.departamento ?: "Não informado"

        // ---------------------------------------------------------------------
        // POLIMORFISMO em execução
        // ---------------------------------------------------------------------
        // `funcionario.calcularBonus()` chama o método da superclasse, mas em
        // tempo de execução o runtime direciona para a implementação correta:
        //   - Se for Gerente     → salarioBase * 0.20
        //   - Se for Desenvolvedor → salarioBase * 0.10
        //
        // Nenhum `is Gerente` ou `is Desenvolvedor` aqui. O polimorfismo
        // elimina a necessidade de checar tipos manualmente.
        // ---------------------------------------------------------------------
        println("Nome:          ${funcionario.nome}")
        println("Departamento:  $departamentoExibido")
        println("Salário Base:  R$ ${"%.2f".format(funcionario.salarioBase)}")
        println("Bônus:         R$ ${"%.2f".format(funcionario.calcularBonus())}")
        println("──────────────────────────────────────")
    }
}
