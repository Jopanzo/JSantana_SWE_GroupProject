/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author johnn
 */
public class Risks {
    String name;
    String status;
    public Risks(String name)
    {
        this.name = name;
        status = "unresolved";
    }
    void changeRiskStatus()
    {
        System.out.println("Please press 0 to declare risk unresolved and 1 to make the risk resolved.");
        Scanner reader = new Scanner(System.in);
        int choice = reader.nextInt();
        if( choice == 0)
        {
            status = "unresolved";
        }
        if(choice == 1)
        {
            status = "resolved";
        }
    }
    
}
