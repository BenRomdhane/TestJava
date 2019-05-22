import org.apache.log4j.BasicConfigurator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartitionMain {


    public static void main(String[] args) {

        BasicConfigurator.configure();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Scanner str = new Scanner(System.in);

        System.out.println("Saisir la taille (entier) :");

        Integer size = str.nextInt();

        List<List<Integer>> result = Arrays.asList(Partition.partition(list, size));

        System.out.println(result);

    }

}
