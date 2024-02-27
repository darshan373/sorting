import java.util.Arrays;

public class mergesort {
    public static void conquer(int[] arr, int s, int mid, int l) {
        int[] merger = new int[l - s + 1];
        int id1 = s;
        int id2 = mid + 1;
        int x = 0;
        while (id1 <= mid && id2 <= l) {
            if (arr[id1] <= arr[id2]) {
                merger[x] = arr[id1];
                x++;
                id1++;
            } else {
                merger[x] = arr[id2];
                x++;
                id2++;
            }
        }
        while (id1 <= mid) {
            merger[x] = arr[id1];
            x++;
            id1++;
        }
        while (id2 <= l) {
            merger[x] = arr[id2];
            x++;
            id2++;
        }
        for (int j = 0, i = s; j < merger.length; j++, i++) {
            arr[i] = merger[j];

        }

    }

    public static void divide(int[] arr, int s, int l) {
        if (s >= l) {
            return;
        }
        int mid = s + (l - s) / 2;
        divide(arr, s, mid);
        divide(arr, mid + 1, l);
        conquer(arr, s, mid, l);

    }

    public static void main(String[] args) {
        int[] a = { 5, 4, 3, 2, 1 };
        divide(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
