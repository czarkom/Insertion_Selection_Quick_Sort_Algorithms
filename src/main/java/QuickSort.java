public class QuickSort implements SortingInterface {
    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null || unsortedVector.length < 1)
            throw new IllegalArgumentException("Please give me normal array, you can't pass null or empty arrays to this method");
        double[] output = unsortedVector.clone();
        if (unsortedVector.length < 20) {
            SortingInterface sorter = new InsertionSort();
            output = sorter.sort(output);
            return output;
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stack.push(output.length);
            while (!stack.isStackEmpty()) {
                int end = stack.pop();
                int start = stack.pop();
                if (end - start < 2) continue;
                int p = start + ((end - start) / 2);
                p = partition(output, p, start, end);
                stack.push(p + 1);
                stack.push(end);
                stack.push(start);
                stack.push(p);
            }
        }
        return output;
    }

    private int partition(double[] vector, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        double pivot = vector[position];
        HelpfulMethods.swap(vector, position, end - 1);
        while (l < h) {
            if (vector[l] < pivot) {
                l++;
            } else if (vector[h] >= pivot) {
                h--;
            } else {
                HelpfulMethods.swap(vector, l, h);
            }
        }
        int index = h;
        if (vector[h] < pivot) {
            index++;
        }
        HelpfulMethods.swap(vector, end - 1, index);
        return index;
    }
}
