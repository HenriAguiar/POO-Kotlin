// =============================================================================
// ABSTRAÇÃO
// =============================================================================
// Uma classe abstrata define um CONTRATO: ela declara o que todo funcionário
// DEVE TER (propriedades) e o que todo funcionário DEVE SABER FAZER (métodos),
// sem implementar os detalhes — isso é responsabilidade de cada subclasse.
//
// Em Kotlin, `abstract class` não pode ser instanciada diretamente:
//   val f = Funcionario(...)  ← ERRO de compilação
// Você só pode instanciar tipos concretos: Gerente, Desenvolvedor, etc.
// =============================================================================

abstract class Funcionario {

    // -------------------------------------------------------------------------
    // PROPRIEDADES ABSTRATAS (Native Properties)
    // -------------------------------------------------------------------------
    // Em vez de declarar campos privados + getters/setters como no Java, Kotlin
    // usa propriedades diretamente. O compilador gera os acessores automaticamente.
    //
    // Java (verboso):                  Kotlin (idiomático):
    //   private String nome;             abstract val nome: String
    //   public String getNome() { ... }
    //
    // `abstract val` significa: "toda subclasse precisa fornecer esse valor".
    // -------------------------------------------------------------------------
    abstract val nome: String
    abstract val salarioBase: Double

    // -------------------------------------------------------------------------
    // NULL SAFETY — Tipo Nullable (String?)
    // -------------------------------------------------------------------------
    // Em Kotlin, por padrão, uma variável NÃO pode ser nula. Para permitir nulo,
    // você precisa declarar o tipo com `?` (String? em vez de String).
    //
    // Isso força o tratamento explícito do nulo em tempo de compilação,
    // eliminando a NullPointerException silenciosa do Java.
    //
    // `departamento` é nullable porque um funcionário pode não ter departamento
    // definido ainda — um cenário real e válido.
    // -------------------------------------------------------------------------
    abstract val departamento: String?

    // -------------------------------------------------------------------------
    // POLIMORFISMO
    // -------------------------------------------------------------------------
    // `abstract fun` define a assinatura do método sem implementação.
    // Cada subclasse vai sobrescrever (`override`) com sua própria lógica.
    //
    // Isso é polimorfismo: o mesmo nome `calcularBonus()` produz resultados
    // diferentes dependendo do tipo concreto do objeto em tempo de execução.
    // Quem chama o método não precisa saber se é um Gerente ou Desenvolvedor.
    // -------------------------------------------------------------------------
    abstract fun calcularBonus(): Double
}
