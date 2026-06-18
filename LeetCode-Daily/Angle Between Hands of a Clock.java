class Solution {
    public double angleClock(int hour, int minutes) {
        // 15 min = 90 degree
        // 1 min = 6 degree

        // 60 minhand min = 5 min hourhand 
        // 1 minhand min = 1/12 min hourhand

        // Math.abs(min - hourMin - min/12) * 6 // formula

        int degree = 6;
        int hourMin = (hour % 12) * 5;

        double displace = (hourMin + minutes / 12.0);
        double ans = Math.abs(minutes - displace) * degree;

        return Math.min(ans, 360 - ans); // for minimun angle
    }
}
