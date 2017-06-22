/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

/**
 *
 * @author khelifza
 */
public class main {
    
    public static void main(String[] args) {
        Controleur3 c = new Controleur3();
        System.out.println(c.getAventuriers().get("Eddy").getRole().toString());
        c.test();
    }
}
