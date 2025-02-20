public class Circular{
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);

        buffer.printBuffer();
    }
}

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;
        if (rear == front) {
            front = (front + 1) % size;
        }
    }

    public void printBuffer() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }
}