package sort;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        for (int i = 0; i < Math.max(ver1.length, ver2.length); i++) {
            String v1Str = i >= ver1.length ? "0" : ver1[i];
            String v2Str = i >= ver2.length ? "0" : ver2[i];
            long v1 = Long.parseLong(v1Str);
            long v2 = Long.parseLong(v2Str);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
