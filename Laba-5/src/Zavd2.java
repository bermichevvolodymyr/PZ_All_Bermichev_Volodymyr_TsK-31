public class Zavd2 {
    public void selectionSort(short[] arr) {
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

    public void insertionSort(short[] arr) {
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

    public void printArray(short[] arr) {
        for (short num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zavd2 obj=new Zavd2();
        short[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        short[] arr2 = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Вихідний масив:");
        obj.printArray(arr1);

        obj.selectionSort(arr1);
        System.out.println("Selection Sort (за спаданням):");
        obj. printArray(arr1);

        obj.insertionSort(arr2);
        System.out.println("Insertion Sort (за спаданням):");
        obj.printArray(arr2);
    }
}
