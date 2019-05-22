import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class PartitionTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldGivenListPartitionedWhenSizeIsValid() {

        //Given
        final List<Integer> partitions = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        final List<Integer> expectedFirstPartition = Arrays.asList(1, 2);

        final List<Integer> expectedLastPartition = Arrays.asList(7);

        //When
        List[] result = Partition.partition(partitions, 2);

        //Then
        Assert.assertNotNull(result);
        Assert.assertEquals(result.length, 4);
        Assert.assertEquals(result[0].size(), 2);
        Assert.assertEquals(result[1].size(), 2);
        Assert.assertEquals(result[2].size(), 2);
        Assert.assertEquals(result[3].size(), 1);
        Assert.assertEquals(result[0], expectedFirstPartition);
        Assert.assertEquals(result[3], expectedLastPartition);

    }

    @Test
    public void shouldThrowExceptionWhenSizeIsZero() {

        expectedException.expect(ArithmeticException.class);

        //Given
        final List<Integer> partitions = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //When
        Partition.partition(partitions, 0);
    }

    @Test
    public void shouldThrowExceptionWhenListPartitionIsNull() {

        expectedException.expect(NullPointerException.class);

        //Given
        final List<Integer> partitions = null;

        //When
        Partition.partition(partitions, 5);

    }

    @Test
    public void shouldThrowExceptionWhenSizeIsNeagative() {

        expectedException.expect(SizeInvalidException.class);

        //Given
        final List<Integer> partitions = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //When
        Partition.partition(partitions, -1);
    }


}
