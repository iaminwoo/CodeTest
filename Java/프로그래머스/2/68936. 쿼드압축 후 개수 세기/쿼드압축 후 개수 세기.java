public class Solution {
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }

    private static class Count {
        public final int zero;
        public final int one;

        private Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        private Count add(Count other) {
            return new Count(this.zero + other.zero, this.one + other.one);
        }
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        for (int y = offsetY ; y < offsetY + size ; y++) {
            for (int x = offsetX ; x < offsetX + size ; x++) {
                if(arr[y][x] != arr[offsetY][offsetX]) {
                    int s = size / 2;
                    return count(offsetX, offsetY, s, arr)
                            .add(count(offsetX + s, offsetY, s, arr))
                            .add(count(offsetX, offsetY + s, s, arr))
                            .add(count(offsetX + s, offsetY + s, s, arr));
                }
            }
        }

        if(arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        } else {
            return new Count(1, 0);
        }
    }
}