package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    private static final int STATION = 65535;

    public static class Operation {
        public String op;
        public int row;
        public int col;

        public Operation() {
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        int baseCount;
        int cmdCount;

        row = sc.nextInt();
        col = sc.nextInt();
        baseCount = sc.nextInt();

        ArrayList<int[]> baseStations = new ArrayList<>();
        for (int i = 0; i < baseCount; i++) {
            int stationRow = sc.nextInt();
            int stationCol = sc.nextInt();
            baseStations.add(new int[]{stationRow, stationCol});
        }
        cmdCount = sc.nextInt();

        ArrayList<Operation> operationList = new ArrayList<>();
        for (int i = 0; i < cmdCount; i++) {
            Operation operation = new Operation();
            operation.op = sc.next();
            operation.row = sc.nextInt();
            operation.col = sc.nextInt();
            operationList.add(operation);
        }

        System.out.println(calSignalIntensity(row, col, baseStations, operationList));
    }

    public static int calSignalIntensity(int row, int col, ArrayList<int[]> baseStations, ArrayList<Operation> operationList) {
        int[][] place = new int[row + 1][col + 1];
        for (int i = 0; i < operationList.size(); i++) {
            if ("add".equals(operationList.get(i).op)) {
                addStation(baseStations, new int[]{operationList.get(i).row, operationList.get(i).col});
                // addSignalToPlace(row, col, place, new int[]{operationList.get(i).row, operationList.get(i).col});
            }
            if ("delete".equals(operationList.get(i).op)) {
                // delSignalToPlace(row, col, place, new int[]{operationList.get(i).row, operationList.get(i).col}, false);
                baseStations = delStation(baseStations, new int[]{operationList.get(i).row, operationList.get(i).col});
            }
        }
        for (int i = 0; i < baseStations.size(); i++) {
            addSignalToPlace(row, col, place, baseStations.get(i));
        }
        int res = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (place[i][j] != STATION) {
                    res += place[i][j];
                }
            }
        }
        return res;
    }

    public static void addStation(ArrayList<int[]> baseStations, int[] baseStation) {
        for (int i = 0; i < baseStations.size(); i++) {
            if (baseStations.get(i)[0] == baseStation[0] && baseStations.get(i)[1] == baseStation[1]) {
                return;
            }
        }
        baseStations.add(baseStation);
    }

    public static ArrayList<int[]> delStation(ArrayList<int[]> baseStations, int[] baseStation) {
        ArrayList<int[]> remainStations = new ArrayList<>();
        for (int i = 0; i < baseStations.size(); i++) {
            if (baseStations.get(i)[0] == baseStation[0] && baseStations.get(i)[1] == baseStation[1]) {
                continue;
            }
            boolean del = false;
            for (int j = 0; j < dirs.length; j++) {
                int curRow = baseStation[0] + dirs[j][0];
                int curCol = baseStation[1] + dirs[j][1];
                if (baseStations.get(i)[0] == curRow && baseStations.get(i)[1] == curCol) {
                    del = true;
                    break;
                }
            }
            if (!del) {
                remainStations.add(baseStations.get(i));
            }
        }
        return remainStations;
    }

    public static void addSignalToPlace(int row, int col, int[][] place, int[] baseStation) {
        if (place[baseStation[0]][baseStation[1]] == STATION) {
            return;
        }
        place[baseStation[0]][baseStation[1]] = STATION;
        for (int i = 0; i < dirs.length; i++) {
            int curRow = baseStation[0] + dirs[i][0];
            int curCol = baseStation[1] + dirs[i][1];
            if (curRow > 0 && curRow <= row && curCol > 0 && curCol <= col && place[curRow][curCol] != STATION) {
                place[curRow][curCol]++;
            }
        }
    }

    // public static void delSignalToPlace(int row, int col, int[][] place, int[] baseStation, boolean end) {
    //     if (place[baseStation[0]][baseStation[1]] == STATION) {
    //         place[baseStation[0]][baseStation[1]] = 0;
    //         for (int i = 0; i < dirs.length; i++) {
    //             int curRow = baseStation[0] + dirs[i][0];
    //             int curCol = baseStation[1] + dirs[i][1];
    //             if (curRow > 0 && curRow <= row && curCol > 0 && curCol <= col && place[curRow][curCol] != STATION) {
    //                 if (place[curRow][curCol] > 0) {
    //                     place[curRow][curCol]--;
    //                 }
    //             }
    //         }
    //     }
    //     if (!end) {
    //         for (int i = 0; i < dirs.length; i++) {
    //             int curRow = baseStation[0] + dirs[i][0];
    //             int curCol = baseStation[1] + dirs[i][1];
    //             if (curRow > 0 && curRow <= row && curCol > 0 && curCol <= col && place[curRow][curCol] == STATION) {
    //                 delSignalToPlace(row, col, place, new int[]{curRow, curCol}, true);
    //             }
    //         }
    //     }
    // }
}
