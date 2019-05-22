import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    public static Logger LOGGER = Logger.getLogger(Partition.class);

    public static <T> List[] partition(final List<T> list, final int taille) {

        int m = 0;
        m = checkArgument(list, taille, m);


        if (list.size() % taille != 0) {
            m++;
        }

        List<T>[] partition = new ArrayList[m];

        for (int i = 0; i < m; i++) {

            int fromIndex = i * taille;

            int toIndex = (i * taille + taille < list.size()) ? i * taille + taille : list.size();

            partition[i] = new ArrayList<>(list.subList(fromIndex, toIndex));
        }

        return partition;
    }

    private static <T> int checkArgument(List<T> list, int taille, int m) {

        if (taille < 0) {
            throw new SizeInvalidException();
        }

        try {
            m = list.size() / taille;

        } catch (ArithmeticException e) {
            LOGGER.error(" Illegal Division by zero ");
        } catch (NullPointerException e) {
            LOGGER.error(" The list is null ");
        }

        return m;
    }
}
