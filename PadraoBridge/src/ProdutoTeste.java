package mercadinho.bridge;

public class ProdutoTeste {

    public static void main(String[] args) {
        System.out.println("INICIANDO TESTES DO SISTEMA\n");

        testarProdutoUnitario();
        System.out.println("PROXIMO");
        testarProdutoPesavel();

        System.out.println("\nTESTES FINALIZADOS");
    }

    public static void testarProdutoUnitario() {
        System.out.println("Teste: Produto Unitário (Arroz R$ 20.00)");
        ProdutoUnitario arroz = new ProdutoUnitario(20.0f);


        arroz.setPromocao(new SemDesconto());
        validar(20.0f, arroz.calcularPrecoFinal(), "Unitário Sem Desconto");


        arroz.setPromocao(new ClienteFiel());
        validar(18.0f, arroz.calcularPrecoFinal(), "Unitário Cliente Fiel");


        arroz.setPromocao(new Liquidacao());
        validar(14.0f, arroz.calcularPrecoFinal(), "Unitário Liquidação");
    }

    public static void testarProdutoPesavel() {
        System.out.println("Teste: Produto Pesável (Carne R$ 50.00/kg - 2kg)");
        ProdutoPesavel carne = new ProdutoPesavel(50.0f);
        carne.setPesoKg(2.0f);


        carne.setPromocao(new SemDesconto());
        validar(100.0f, carne.calcularPrecoFinal(), "Pesável Sem Desconto");


        carne.setPromocao(new ClienteFiel());
        validar(90.0f, carne.calcularPrecoFinal(), "Pesável Cliente Fiel");

        carne.setPromocao(new Liquidacao());
        validar(70.0f, carne.calcularPrecoFinal(), "Pesável Liquidação");
    }

     Método auxiliar para validar os resultados

    private static void validar(float esperado, float atual, String cenario) {
        float delta = 0.001f;
        if (Math.abs(esperado - atual) < delta) {
            System.out.println("[ OK ] " + cenario + ": R$ " + atual);
        } else {
            System.err.println("[ ERRO ] " + cenario + ": Esperava " + esperado + " mas obteve " + atual);
        }
    }
}