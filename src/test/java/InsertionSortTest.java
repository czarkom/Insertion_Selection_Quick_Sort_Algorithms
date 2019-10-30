import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    SortingInterface sorter = new InsertionSort();

    @Test
    public void sort() {
        assertEquals(0,0.0, 0);
        double[] input = {11.3, 128, 231, 0.3, -23, 128, 12};
        sorter.sort(input);
        double[] correctOutput = {-23, 0.3, 11.3, 12, 128, 128, 231};
        assertArrayEquals(input, correctOutput, 0);
    }
}