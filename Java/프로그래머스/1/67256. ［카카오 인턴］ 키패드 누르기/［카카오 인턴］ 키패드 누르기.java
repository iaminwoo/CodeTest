class Solution {
    private static class Thumb {
        private int x;
        private int y;
        
        private Thumb(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        private int getDist(Cord cord) {
            int xDist = Math.abs(cord.x - x);
            int yDist = Math.abs(cord.y - y);
            return xDist + yDist;
        }
        
        private void press(Cord cord) {
            this.x = cord.x;
            this.y = cord.y;
        }
    }
    
    private static class Cord {
        private int x;
        private int y;
        
        private Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Cord getCord(int num) {
        if(num == 0) return new Cord(2, 4);
        
        int x = (num % 3) == 0 ? 3 : (num % 3);
        int y = ((num - 1) / 3) + 1;
        return new Cord(x, y);
    }
    
    private String press(Cord cord, String hand, Thumb left, Thumb right) {
        if(cord.x < 2) {
            left.press(cord);
            return "L";
        } else if(cord.x > 2) {
            right.press(cord);
            return "R";
        } else {
            int leftDist = left.getDist(cord);
            int rightDist = right.getDist(cord);

            if(leftDist < rightDist) {
                left.press(cord);
                return "L";
            } else if(leftDist > rightDist) {
                right.press(cord);
                return "R";
            } else {
                if(hand.equals("left")) {
                    left.press(cord);
                    return "L";
                } else {
                    right.press(cord);
                    return "R";
                }
            }
        }
    }
    
    public String solution(int[] numbers, String hand) {
        Thumb left = new Thumb(1, 4);
        Thumb right = new Thumb(3, 4);
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers) {
            Cord cord = getCord(num);
            
            sb.append(
                press(cord, hand, left, right)
            );
        }
        
        return sb.toString();
    }
}