// definimos a class
class Automovel {
    String marca;
    int ano;
    boolean ligado;

    // definir o método construtor
    public Automovel(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
        this.ligado = false;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println(marca + " esta ligado!");
        } else {
            System.out.println(marca + " ja esta ligado, não precisa ligar novamente!");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println(marca + " foi desligado!!!");
        } else {
            System.out.println(marca + " já esta desligado, não precisa desligar!!!");
        }
    }
}

class Car extends Automovel {
    float potencia;
    int marcha;
    String modelo;
    int velocidade;

    // método construtor
    public Car(String marca, int ano, boolean ligado) {
        super(marca, ano);
        this.potencia = potencia;
        this.marcha = 0;
        this.modelo = modelo;
        this.velocidade = 0;
    }

    public Car(String tesla) {
        super("tesla", 0);
    }

    // acelerar
    public void acelerar() {
        if (ligado) {
            velocidade += 5;
            if (velocidade < 20) {
                marcha = 1;
            } else if (velocidade < 40) {
                marcha = 2;
            } else if (velocidade < 60) {
                marcha = 3;
            } else if (velocidade < 80) {
                marcha = 4;
            } else if (velocidade < 220) {
                marcha = 5;
            } else if (velocidade > 220) {
                velocidade = 220;
            }
            System.out.println(modelo + " esta na " + marcha + "ª marcha e " + velocidade + "km/h");
        } else {
            System.out.println("O carro esta desligado por isso não pode acelerar!!!");
        }
    }

    // reduzir
    public void reduzir() {
        if (ligado) {
            velocidade -= 5;
            if (velocidade < 0) {
                velocidade = 0;
                System.out.println("O carro esta na marcha Neutra e parado!!!");
            } else if (velocidade < 20) {
                marcha = 1;
            } else if (velocidade < 40) {
                marcha = 2;
            } else if (velocidade < 60) {
                marcha = 3;
            } else if (velocidade < 80) {
                marcha = 4;
            } else if (velocidade < 220) {
                marcha = 5;
            } else if (velocidade > 220) {
                velocidade = 220;
            }
            System.out.println(modelo + " esta na " + marcha + "ª marcha e " + velocidade + "km/h");
        } else {
            System.out.println("O carro está na marcha neutra, não pode acelerar!!!");
        }
    }

    public class Moto extends Automovel {
        String modelo;
        String ano;
        int velocidade;
        float potencia;
        int marcha;
        int cilindrada;

        public Moto(String marca, int ano, float potencia, String modelo) {
            super(marca, ano);
            this.modelo = modelo;
            this.velocidade = 0;
            this.potencia = potencia;
            this.marcha = 0;
        }

        public void acelerar() {
            if (ligado) {
                velocidade += 5;
                System.out.println("A moto está na marcha Neutra e parado!!!");
                if (velocidade < 20) {
                    marcha = 1;
                } else if (velocidade < 40) {
                    marcha = 2;
                } else if (velocidade < 60) {
                    marcha = 3;
                } else if (velocidade < 80) {
                    marcha = 4;
                } else if (velocidade < 170) {
                    marcha = 5;
                } else if (velocidade > 170) {
                    velocidade = 170;
                }

                System.out.println(modelo + " esta na " + marcha + "ª marcha e " + velocidade + "km/h");
            } else {
                System.out.println("A Moto esta desligada por isso não pode acelerar!!!");
            }
        }

        public void reduzir() {
            if (ligado) {
                velocidade -= 5;
                if (velocidade < 0) {
                    velocidade = 0;
                } else if (velocidade < 20) {
                    marcha = 1;
                } else if (velocidade < 40) {
                    marcha = 2;
                } else if (velocidade < 60) {
                    marcha = 3;
                } else if (velocidade < 80) {
                    marcha = 4;
                } else if (velocidade < 170) {
                    marcha = 5;
                } else if (velocidade > 170) {
                    velocidade = 170;
                }
                System.out.println(modelo + " esta na " + marcha + "ª marcha e " + velocidade + "km/h");
            } else {
                System.out.println("A moto está na marcha neutra, não pode acelerar!!!");
            }
        }
    }
}

class Motorista {
    private static Veiculo entrarnocarro;
    private String nome;
    private int idade;
    private double peso;
    private String habilit;
    private Veiculo relacao; // O motorista pode ter um veículo, que será instanciado como Moto ou Carro
    private Veiculo carro;

    public Motorista(String nome, int idade, double peso, String habilit) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.habilit = habilit;
        this.relacao = null;
    }

    public void subirmoto(Moto moto) {
        if (habilit.equals("A") || habilit.equals("AB")) {
            if (relacao == null) {
                relacao = moto;
                System.out.println(nome + " subiu na moto " + relacao.getModelo());
            } else {
                System.out.println(nome + " já possui um veículo " + relacao.getModelo());
                relacao = moto;
                System.out.println(nome + " trocou de veículo e subiu na moto " + relacao.getModelo());
            }
        } else {
            System.out.println(nome + " não possui habilitação para pilotar moto!");
        }
    }

    public void entrarnocarro(Car carro) {
        if (habilit.equals("B") || habilit.equals("AB")) {
            if (relacao == null) {
                relacao = Motorista.entrarnocarro;
                System.out.println(nome + " entrou no carro " + relacao.getModelo());
            } else {
                System.out.println(nome + " já possui um veículo " + relacao.getModelo());
                relacao = this.carro;
                System.out.println(nome + " trocou de veículo e entrou no carro " + relacao.getModelo());
            }
        } else {
            System.out.println(nome + " não possui habilitação para dirigir carro!");
        }
    }

    public void ligarveiculo() {
        if (relacao != null && !relacao.isLigado()) {
            relacao.ligar();
        } else {
            System.out.println("O veículo já está ligado ou não foi atribuído ainda.");
        }
    }

    public void desligarveiculo() {
        if (relacao != null && relacao.isLigado()) {
            relacao.desligar();
        } else {
            System.out.println("O veículo já está desligado ou não foi atribuído ainda.");
        }
    }

    public void acelerarveiculo() {
        if (relacao != null && relacao.isLigado()) {
            relacao.acelerar();
        } else {
            System.out.println("O veículo já está desligado ou não foi atribuído ainda.");
        }
    }

    public void frear() {
        if (relacao != null && relacao.isLigado()) {
            relacao.reduzir();
        } else {
            System.out.println("O veículo já está desligado ou não foi atribuído ainda.");
        }
    }
}

abstract class Veiculo {
    protected String modelo;
    protected boolean ligado;

    public Veiculo(String modelo) {
        this.modelo = modelo;
        this.ligado = false;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        ligado = true;
        System.out.println("Veículo ligado.");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Veículo desligado.");
    }

    public abstract void acelerar();

    public abstract void reduzir();
}

class Moto extends Veiculo {
    public Moto(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando a moto " + modelo);
    }

    @Override
    public void reduzir() {
        System.out.println("Reduzindo a velocidade da moto " + modelo);
    }
}

class Carro extends Veiculo {
    public Carro(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando o carro " + modelo);
    }

    @Override
    public void reduzir() {
        System.out.println("Reduzindo a velocidade do carro " + modelo);
    }
}


public class Dirigir {
    public static void main(String[] args) {
        Carro carro = new Carro("Tesla");

        System.out.println(carro.modelo);

        carro.ligar();

        for (int i = 0; i < 5; i++) {
            carro.acelerar();
        }

        carro.acelerar();

        carro.desligar();
    }
}
