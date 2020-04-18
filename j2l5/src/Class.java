import java.util.Arrays;

public class Class {
    static final int size = 10000000;
    static final int h = size / 2;
    static final float[] arr = new float[size];

    public static void main(String[] args) {
        simpleArray();
        halfArray();
    }

    public static void simpleArray(){
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println((System.currentTimeMillis() - a) + "ms");
    }

    public static void halfArray(){
        final float[] a1 = new float[h];
        final float[] a2 = new float[h];
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        for (int i = 0; i < a1.length ; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < a2.length ; i++) {
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println((System.currentTimeMillis() - b) + "ms");

    }
}
