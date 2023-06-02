package Torres_Hannoi;

import java.util.Random;

public class Principal {

    static HannoiGame hannoi = new HannoiGame();

    static TowerList[] torres = new TowerList[3];

    public static void main(String[] args) {
        System.out.println(hannoi.getTorre1().size());
        torres[0] = hannoi.getTorre1();
        torres[1] = hannoi.getTorre2();
        torres[2] = hannoi.getTorre3();
        System.out.println(torres[0]);
        System.out.println(torres[1]);
        System.out.println(torres[2]);
        jugar();
        System.out.println(torres[0]);
        System.out.println(torres[1]);
        System.out.println(torres[2]);

    }

    public static void jugar() {
        Random random = new Random();
        int numero1;
        int numero2;

        do {
            do {
                numero1 = random.nextInt(3);
            } while (Comprobar(numero1) == false);
            do {
                numero2 = random.nextInt(3);
            } while (numero2 == numero1);

            System.out.println(hannoi.mover(torres[numero1], torres[numero2]));
            System.out.println("Moviento= " + hannoi.getMovimientos() + " Desde= Torre " + numero1 + " hacia= Torre " + numero2);
            System.out.println(torres[0]);
            System.out.println(torres[1]);
            System.out.println(torres[2]);
        } while (torres[2].esIgual(hannoi.getTorreReferencia()) == false);

        System.out.println("numero de intentos= " + hannoi.getMovimientos());
    }

    public static boolean Comprobar(int numero) {
        if (numero != 2) {
            System.out.println("-------distito de 2----------");
            return true;
        }
        for (int i = hannoi.getTorreReferencia().size() - 1; i > -1; i--) {
            if ((hannoi.getTorre3().getDisk()[i].getTamaño() != 0 && hannoi.getTorre3().getDisk()[i].getTamaño() != hannoi.getTorreReferencia().getDisk()[i].getTamaño())) {
                System.out.println("------Distinto de 0 y distinto de numero correspondiente----------");
                return true;
            } else if ((hannoi.getTorre3().getDisk()[i].getTamaño() != 0 && hannoi.getTorre3().getDisk()[i].getTamaño() == hannoi.getTorreReferencia().getDisk()[i].getTamaño())) {
                return false;

            }
        }
        return false;
    }
}
