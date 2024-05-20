package Main;

import Model.Purchase;

import javax.print.attribute.standard.Finishings;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double limit;
        Scanner in = new Scanner(System.in);
        List<Purchase> purchaseList = new ArrayList<>();
        System.out.println("Insira um limite: ");
        limit = in.nextDouble();
        in.nextLine();
        Double _limit = limit;
        while (true)
        {
            System.out.println("Insira Descrição da Compra: ");
            String desc = in.nextLine();
            System.out.println("Insira o valor da compra: ");
            double value = in.nextDouble();
            in.nextLine();
            if(value > limit)
            {
                System.out.println("Valor da Compra Excede o Limite do Cartão");
                continue;
            }

            if(purchaseList.isEmpty())
            {
                Purchase compra = new Purchase(desc,value);
                purchaseList.add(compra);
                _limit -= compra.getValue();
            }
            else
            {
                double purchaseTotal =0;
                for(Purchase p: purchaseList)
                {
                    purchaseTotal+= p.getValue();
                }
                if(purchaseTotal+value > limit)
                {
                    System.out.println("Valor da Compra Excede o Limite do Cartão");
                }
                else
                {
                    Purchase compra = new Purchase(desc,value);
                    purchaseList.add(compra);
                    _limit -= compra.getValue();
                }
            }
            int result = Finish(in);
            if(result==0)
            {
                break;
            }
            else if (result==1)
            {
                continue;
            }
        }
        purchaseList.sort(Comparator.comparing(Purchase::getValue));
        System.out.println("Compras Realizadas: ");
        System.out.println("**************************");
        System.out.println(purchaseList);
        System.out.println("Limite Restante é: " + _limit);
        System.out.println("**************************");
    }

    static int Finish(Scanner in)
    {
        while(true)
        {
            System.out.println("Deseja Continuar Comprando? S:Sim | N:Não");
            String A = in.nextLine();
            if (A.equals("S"))
            {
                return 1;
            }
            else if(A.equals("N"))
            {
                return 0;
            }
            else
            {
                continue;
            }
        }

    }

}