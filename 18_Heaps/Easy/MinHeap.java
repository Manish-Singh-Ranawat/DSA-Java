public class MinHeap {
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public void offer(int val) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = val;
        upHeap(size);
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int val = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downHeap(0);
        return val;
    }

    private void upHeap(int idx) {
        int p = parent(idx);
        while (idx != 0 && heap[p] > heap[idx]) {
            swap(p, idx);
            idx = p;
            p = parent(idx);
        }
    }

    private void downHeap(int idx) {
        while (true) {
            int maxIdx = idx;
            int left = leftChild(idx);
            int right = rightChild(idx);
            if (left < size && heap[left] < heap[maxIdx]) {
                maxIdx = left;
            }
            if (right < size && heap[right] < heap[maxIdx]) {
                maxIdx = right;
            }
            if (maxIdx == idx) {
                break;
            }
            swap(idx, maxIdx);
            idx = maxIdx;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.offer(10);
        heap.offer(20);
        heap.offer(30);
        System.out.println(heap.peek()); // 10
        heap.poll();
        System.out.println(heap.peek()); // 20
        System.out.println(heap.toString()); // [20, 30]
    }
}
