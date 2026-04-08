// =============================================================================
// HERANÇA + DATA CLASS
// =============================================================================
// `data class` é um recurso do Kotlin para classes que existem principalmente
// para carregar dados. O compilador gera automaticamente:
//   - equals() / hashCode()  → comparação por valor, não por referência
//   - toString()             → representação legível: Gerente(nome=Ana, ...)
//   - copy()                 → cria uma cópia com campos alterados
//
// `: Funcionario()` declara a herança — Gerente É UM Funcionario.
// Herança modela a relação "é um" e permite que Gerente seja tratado
// como Funcionario em qualquer lugar do código.
// =============================================================================

data class Gerente(

    // -------------------------------------------------------------------------
    // OVERRIDE DE PROPRIEDADES
    // -------------------------------------------------------------------------
    // Como Funcionario declara `abstract val nome`, Gerente precisa implementar
    // essa propriedade com `override val`. É a mesma lógica de `override fun`:
    // a subclasse cumpre o contrato definido pela classe abstrata.
    //
    // O construtor primário é a forma idiomática do Kotlin de declarar e
    // inicializar propriedades ao mesmo tempo — sem corpo de construtor separado.
    // -------------------------------------------------------------------------
    override val nome: String,
    override val salarioBase: Double,
    override val departamento: String?

) : Funcionario() {

    // -------------------------------------------------------------------------
    // SOBRESCRITA DE MÉTODO (Polimorfismo em ação)
    // -------------------------------------------------------------------------
    // `override fun` substitui a implementação abstrata da superclasse.
    // A regra de negócio do Gerente (20% de bônus) fica encapsulada aqui,
    // separada da regra do Desenvolvedor — cada classe cuida da sua própria lógica.
    //
    // A sintaxe `= expressão` (sem chaves) é usada quando o método tem
    // apenas uma expressão para retornar — mais conciso e legível.
    // -------------------------------------------------------------------------
    override fun calcularBonus() = salarioBase * 0.20
}
