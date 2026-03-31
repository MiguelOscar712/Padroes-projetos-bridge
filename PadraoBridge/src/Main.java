package mercadinho.bridge;

public class Main {
    public static void main(String[] args) {
        Promocao semdesconto = new SemDesconto();


        ProdutoUnitario arroz = new ProdutoUnitario(20.0f);
        arroz.setPromocao(semdesconto);
        System.out.println("Preço Arroz: " + arroz.calcularPrecoFinal());


        ProdutoPesavel carne = new ProdutoPesavel(50.0f);
        carne.setPesoKg(2.0f);
        carne.setPromocao(semdesconto);
        System.out.println("Preço Carne: " + carne.calcularPrecoFinal());
    }
}