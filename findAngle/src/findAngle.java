public class findAngle {
    public static void main(String[] args) {
        // Lengths of triangle in picture
        // 'A' length in triangle
        double aSide = 5.0;
        // 'A' length in triangle
        double bSide = 12.0;
        //Hypotenuse length
        double hypoUse = 13.0;

        // Find Theta (θ) in degrees
        double θDegree = Math.toDegrees(Math.asin(aSide / hypoUse));

        // Find Eta (η) in degrees
        double ηDegree = Math.toDegrees(Math.asin(bSide / hypoUse));

        //Round the final numbers to the nearest int
        int roundθ = (int) Math.round(θDegree);
        int roundη = (int) Math.round(ηDegree);


        // Display the results
        System.out.println("Theta (θ) in degree using Soh " + roundθ + "°");
        System.out.println("Eta (η) in degree using Soh: " + roundη + "°");
    }
}

