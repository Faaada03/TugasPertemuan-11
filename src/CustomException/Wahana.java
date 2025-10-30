/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomException;

/**
 *
 * @author MyBook Hype AMD
 */
//
class TinggibadanTidakMemenuhi extends Exception {

    public TinggibadanTidakMemenuhi(String n) {
        super(n);
    }
}

public class Wahana {

    public static void CektinggiBadan(int tinggi) throws TinggibadanTidakMemenuhi {
        if (tinggi < 165) {

            throw new TinggibadanTidakMemenuhi("Tinggi badan harus di atas 160");
        }
        System.out.println("Tinggi :" + tinggi + " cm. Tinggi badan memenuhi karena di atas batas, yaitu 165 cm.");
    }

    public static void main(String[] args) {
        try {
            
            CektinggiBadan(170);
        } catch (TinggibadanTidakMemenuhi e) {

            System.out.println(" Maaf,Tidak diizinkan : " + e.getMessage());

        }
    }
}
