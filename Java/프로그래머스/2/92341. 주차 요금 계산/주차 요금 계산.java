import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private class Car {
        int timeSum = 0;
        final int carNum;
        boolean in = false;
        
        private Car(int carNum) {
            this.carNum = carNum;
        }
        
        private void in(String inTime) {
            timeSum -= timeCal(inTime);
            in = true;
        }
        
        private void out(String outTime) {
            timeSum += timeCal(outTime);
            in = false;
        }
        
        private int timeCal(String time) {
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
        
        private int getSum() {
            int sum = this.timeSum;
            if(in) sum += 1439;
            return sum;
        }
        
        private int getCarNum() {
            return carNum;
        }
    }
    
    private int getFee(int timeSum, int[] fees) {
        if(timeSum > fees[0]) {
            int feeSum = fees[1];
            
            int overTime = timeSum - fees[0];
            feeSum += (overTime / fees[2]) * fees[3];
            if(overTime % fees[2] != 0) feeSum += fees[3];
            
            return feeSum;
        } else {
            return fees[1];
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Car> carMap = new HashMap<>();
        
        for(String record : records) {
            String[] parts = record.split(" ");
            
            int carNum = Integer.parseInt(parts[1]);
            Car car = carMap.computeIfAbsent(carNum, cn -> new Car(cn));
            
            if(parts[2].equals("IN")) {
                car.in(parts[0]);
            } else {
                car.out(parts[0]);
            }
        }
        
        List<Car> carList = carMap.values().stream()
            .sorted(Comparator.comparing(Car::getCarNum))
            .collect(Collectors.toList());
        
        int[] answer = new int[carList.size()];
        
        for(int i = 0 ; i < carList.size() ; i++) {
            Car c = carList.get(i);
            answer[i] = getFee(c.getSum(), fees);
        }
        
        return answer;
    }
}