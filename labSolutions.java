public class Main {
    public static void main(String[] args) {
        // --- Task 1: Circle ---
        System.out.println("=== LAB TASK 1: CIRCLE ===");
        CircleShape defaultCircle = new CircleShape();
        CircleShape customCircle = new CircleShape(6.0, 1.5);
        System.out.println("Default Radius: " + defaultCircle.fetchRadius() + " | Circumference: " + defaultCircle.computeCircumference());
        System.out.println("Custom Scaled Radius: " + customCircle.fetchRadius() + " | Circumference: " + customCircle.computeCircumference());

        // --- Task 2: Account ---
        System.out.println("\n=== LAB TASK 2: ACCOUNT ===");
        BankAccount userAccount = new BankAccount(750.0, 50.0);
        System.out.println("Starting Balance: $" + userAccount.readBalance());
        userAccount.addFunds(200.0);
        userAccount.deductFunds(100.0);
        System.out.println("Current Balance: $" + userAccount.readBalance());

        // --- Task 3: Distance ---
        System.out.println("\n=== LAB TASK 3: DISTANCE ===");
        SpatialDistance pointA = new SpatialDistance();
        SpatialDistance pointB = new SpatialDistance(3, 16.5); // 16.5 inches normalizes to 4 ft 4.5 in
        pointA.showDetails();
        pointB.showDetails();

        // --- Task 4: Marks ---
        System.out.println("\n=== LAB TASK 4: MARKS ===");
        StudentScore recordA = new StudentScore();
        StudentScore recordB = new StudentScore(91.5, 84.0, 78.5);
        System.out.println("Record A Total Marks: " + recordA.obtainTotalScore());
        System.out.println("Record B Total Marks: " + recordB.obtainTotalScore());

        // --- Task 5: Time ---
        System.out.println("\n=== LAB TASK 5: TIME ===");
        ClockTime defaultClock = new ClockTime();
        ClockTime validClock = new ClockTime(11, 45, 30);
        ClockTime invalidClock = new ClockTime(30, 75, -10); // Triggers validation check

        defaultClock.renderTime();
        validClock.renderTime();
        invalidClock.renderTime();
    }
}

// ==========================================
// TASK 1 CLASS
// ==========================================
class CircleShape {
    private double radiusValue;

    public CircleShape() {
        this.radiusValue = 1.0;
    }

    public CircleShape(double initialRadius, double multiplier) {
        this.radiusValue = initialRadius * multiplier;
    }

    public double computeCircumference() {
        return 2 * Math.PI * radiusValue;
    }

    public double fetchRadius() {
        return radiusValue;
    }
}

// ==========================================
// TASK 2 CLASS
// ==========================================
class BankAccount {
    private double currentBalance;

    public BankAccount() {
        this.currentBalance = 0.0;
    }

    public BankAccount(double baseAmount, double bonus) {
        this.currentBalance = baseAmount + bonus;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            this.currentBalance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void deductFunds(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            this.currentBalance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient funds.");
        }
    }

    public double readBalance() {
        return currentBalance;
    }
}

// ==========================================
// TASK 3 CLASS
// ==========================================
class SpatialDistance {
    private int feetVal;
    private double inchesVal;

    public SpatialDistance() {
        this.feetVal = 0;
        this.inchesVal = 0.0;
    }

    public SpatialDistance(int feetVal, double inchesVal) {
        this.feetVal = feetVal;
        this.inchesVal = inchesVal;
        adjustUnits();
    }

    private void adjustUnits() {
        if (this.inchesVal >= 12.0) {
            this.feetVal += (int) (this.inchesVal / 12);
            this.inchesVal = this.inchesVal % 12;
        }
    }

    public void showDetails() {
        System.out.println("Distance: " + feetVal + " feet, " + inchesVal + " inches");
    }
}

// ==========================================
// TASK 4 CLASS
// ==========================================
class StudentScore {
    private double score1;
    private double score2;
    private double score3;

    public StudentScore() {
        this.score1 = 0.0;
        this.score2 = 0.0;
        this.score3 = 0.0;
    }

    public StudentScore(double score1, double score2, double score3) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public double obtainTotalScore() {
        return score1 + score2 + score3;
    }
}

// ==========================================
// TASK 5 CLASS
// ==========================================
class ClockTime {
    private int hours;
    private int minutes;
    private int seconds;

    public ClockTime() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public ClockTime(int hours, int minutes, int seconds) {
        applyValidatedValues(hours, minutes, seconds);
    }

    public void applyValidatedValues(int h, int m, int s) {
        this.hours = (h >= 0 && h < 24) ? h : 0;
        this.minutes = (m >= 0 && m < 60) ? m : 0;
        this.seconds = (s >= 0 && s < 60) ? s : 0;
    }

    public void renderTime() {
        System.out.printf("Time: %02d:%02d:%02d\n", hours, minutes, seconds);
    }
}
