/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomException;

/**
 *
 * @author MyBook Hype AMD
 */
class CustomException extends Exception {

    public CustomException(String a) {
        super(a);
    }

}

public class SetTex {

    public static void main(String[] args) {
        try {
            throw new CustomException("");
        } 
        catch (CustomException ex) {
            System.out.println("caught");
            System.out.println(ex.getMessage());

        }

    }
}
