import java.util.Scanner;

/**
 * Queue2
 */
public class Queue2 {
    static int size;
    static int r = -1;
    static int f = -1;
    static int[] arr;

    Queue2(int z) {
        size = z;
        arr = new int[z];
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        @SuppressWarnings("unused")
        Queue2 q = new Queue2(5);
        int n;
        int count = 1;

        do {
            double y = Math.random() * 100;
            n = sc.nextInt();
            switch (n) {
                case 1:
                    frontAdd((int) y);
                    break;
                case 2:
                    frontdelete();
                    break;
                case 3:
                    rearAdd((int) Math.random() * 10);
                    break;
                case 4:
                    rearDelete();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    reverse(Queue2.f);
                    break;
            }
        } while (n != 10);

    }

    static void reverse(int front) {
        if (f == -1) {
            return;
        } else {
            int xx = deQueue();
            reverse(front);
            rearAdd(xx);
        }
    }

    public static void rearAdd(int x) {
        if ((r == size - 1 && f == 0) || (f == r + 1)) {
            System.out.println("overflow");
        } else {
            if (r == -1) {
                r++;
                f++;
            } else if (r == size - 1 && f > 0) {
                r = 0;
            } else {
                r++;
            }
            arr[r] = x;
            System.out.println(arr[r] + " is inserted at rear");
        }
    }

    public static void frontdelete() {
        if (f == -1) {
            System.out.println("underflow");
        } else {
            int y = arr[f];
            if (f == r) {
                f = -1;
                r = -1;
            } else if (f == size - 1) {
                f = 0;

            } else {
                f++;
            }
            System.out.println(y + "is deinsted from front");
        }
    }

    static int deQueue() {
        if (f == -1) {
            System.out.println("underflow");
            return 0;
        } else {
            int y = arr[f];
            if (f == r) {
                f = -1;
                r = -1;
            } else if (f == size - 1) {
                f = 0;

            } else {
                f++;
            }
            System.out.println(y + "is deinsted from front");
            return y;
        }
    }

    static void display() {
        if (f == -1) {
            System.out.println("empty");
        } else {
            if (r >= f) {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = f; i < size; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }

            }
        }

    }

    static void frontAdd(int x) {
        if (f == r + 1 || (f == 0 && r == size - 1)) {
            System.out.println("overflow");
        } else {
            if (f == -1) {
                f = 0;
                r = 0;
            } else if (f == 0) {
                f = size - 1;
            } else {
                f--;
            }
            arr[f] = x;
            System.out.println(x + " is inserted at front");
        }
    }

    static void rearDelete() {
        if (f == -1 && r == -1) {
            System.out.println("underflow");
        } else {
            int y = arr[r];
            if (f == r) {
                f = r = -1;
            } else if (r == 0) {
                r = size - 1;
            } else {
                r--;
            }
            System.out.println(y + "is deleted from rear");
        }
    }
}