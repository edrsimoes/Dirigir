public class Main {
    public static void main(String[] args) {
        Motorista motorista = new Motorista("João", 30, 75.5, "AB");

        Moto moto = new Moto("Honda CBR500");
        Car carro = new Car("Tesla");

        motorista.subirmoto(moto);
        motorista.entrarnocarro(carro);

        motorista.ligarveiculo();
        motorista.acelerarveiculo();
        motorista.frear();
        motorista.desligarveiculo();
    }
}
