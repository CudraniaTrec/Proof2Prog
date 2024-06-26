//maximum-units-on-a-truck
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        int remainingTruckSize = truckSize;
        while (remainingTruckSize > 0) {
            int maxUnitBoxIndex = findMaxUnitBox(boxTypes);
            // check if all boxes are used
            if (maxUnitBoxIndex == -1)
                break;
            // find the box count that can be put in truck
            int boxCount = Math.min(remainingTruckSize, boxTypes[maxUnitBoxIndex][0]);
            unitCount += boxCount * boxTypes[maxUnitBoxIndex][1];
            remainingTruckSize -= boxCount;
            // mark box with index maxUnitBoxIndex as used
            boxTypes[maxUnitBoxIndex][1] = -1;
        }
        return unitCount;
    }

    public int findMaxUnitBox(int[][] boxTypes) {
        int maxUnitBoxIndex = -1;
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][1] > maxUnits) {
                maxUnits = boxTypes[i][1];
                maxUnitBoxIndex = i;
            }
        }
        return maxUnitBoxIndex;
    }
}
