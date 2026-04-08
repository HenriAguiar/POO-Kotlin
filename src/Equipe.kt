// =============================================================================
// ENCAPSULAMENTO + FIRST-CLASS COLLECTION
// =============================================================================
// Encapsulamento significa esconder os detalhes internos de uma classe e
// expor apenas o que é necessário para o mundo externo.
//
// Aqui aplicamos o princípio "First-Class Collection" do Object Calisthenics:
// uma coleção nunca fica "solta" no código. Em vez de passar um List<Funcionario>
// pelo main() e iterar diretamente, criamos uma classe que:
//   1. Encapsula a lista com `private val` — ninguém acessa membros diretamente
//   2. Expõe apenas operações com significado de negócio (paraCadaMembro)
//
// Benefício: se amanhã quisermos ordenar, filtrar ou validar a lista antes de
// iterar, há um único lugar para fazer isso — aqui dentro, sem tocar no main().
// =============================================================================

class Equipe(private val membros: List<Funcionario>) {

    // -------------------------------------------------------------------------
    // ABSTRAÇÃO DA ITERAÇÃO
    // -------------------------------------------------------------------------
    // Em vez de expor a lista e deixar o chamador fazer `for (f in equipe.membros)`,
    // fornecemos um método que aceita uma função como parâmetro (lambda).
    //
    // `(Funcionario) -> Unit` é o tipo de uma função que recebe um Funcionario
    // e não retorna nada. Isso é uma função de alta ordem (higher-order function),
    // recurso central da programação funcional integrado ao Kotlin.
    //
    // O chamador decide O QUE fazer com cada membro; a Equipe decide COMO iterar.
    // -------------------------------------------------------------------------
    fun paraCadaMembro(acao: (Funcionario) -> Unit) = membros.forEach(acao)
}
