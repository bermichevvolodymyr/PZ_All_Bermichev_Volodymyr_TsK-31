public class Zavd2 {
    public static void selectionSort(short[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            short temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(short[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            short key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(short[] arr) {
        for (short num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        short[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        short[] arr2 = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Вихідний масив:");
        printArray(arr1);

        selectionSort(arr1);
        System.out.println("Selection Sort (за спаданням):");
        printArray(arr1);

        insertionSort(arr2);
        System.out.println("Insertion Sort (за спаданням):");
        printArray(arr2);
    }
}