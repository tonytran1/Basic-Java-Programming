package simplestatistics;
import java.text.*; //DecimalFormating for limiting decimal points.
import java.util.Random; //Random utility needed for part 2.

/*    The following code does part 1 and 2 which is detailed below.

Part 1.	Generate 400 samples of size 225 random numbers from U(10, 12). 
For each of these 400 samples calculate the mean. 

A   Find the simulated probability that the mean is between 10.4 and 11.1 
    inclusive.
B.  Find the mean of the means.
C.  Find the standard deviation of the means.

Part 2. Generate 1600 samples of size 324 random integers from the set 
{10, 20, 30, 40, 50, 60}. For each of these 1600 samples calculate the mean. 

a.  Find the simulated probability that the mean is between 29.5 and 34.5 
    exclusive.
b.  Find the simulated mean of the means.
c.  Find the simulated standard deviation of the means.

*/
public class SimpleStatistic {
static DecimalFormat d = new DecimalFormat("#.##"); /*Static decimal formating 
so it can be used by the whole java file.*/
static DecimalFormat m = new DecimalFormat("##.#####"); //same as above.

/*Code below is for method used for Part 1 question A. Part 2 differs
so method was not able to be reused.
*/
 public static void sampleMean(double[] sampleMean, double[] x, double xsum,
 int start, int multi, int num){ 
    for(int i = 0; i < sampleMean.length; i++){
      xsum = 0; 
      x = new double[num];
    for(int ii = 0; ii < x.length; ii++){
      x[ii] = start + (Math.random()*multi);
      xsum += x[ii];
      }
      sampleMean[i] = xsum/num;
//Next line prints list of means from sample size.
      System.out.println(d.format(sampleMean[i]));
        }
    }
 
 
//Code below is for the method used for Part 2 question A.
//This method grabs the means of all 1600 sample sizes and prints them.
 public static void sampleMean(double[] sampleMean, int[] y, int[] set, 
 double xsum, int min, int max, int num){
     for(int i = 0; i < sampleMean.length; i++){
        xsum = 0;
    for(int ii = 0; ii < y.length; ii++){
        Random rand = new Random();
        int random = min + rand.nextInt(max - min + 1);
        y[ii] = set[random];
        xsum += y[ii];
     }
     sampleMean[i] = xsum/num;
//Code below prints means of the 1600 sample sizes.
//The output will be needed for the histogram.
     System.out.println(d.format(sampleMean[i]));
        }
    }
 
 
//Code below is for the method used for Parts 1 and 2, question B.
//This method calculates the mean of means.
 public static double meanOfMeans(double[] sampleMean, double meanSum, 
 int num){
    for(int i = 0; i < sampleMean.length; i++){
     meanSum += sampleMean[i];
    }
     double meanOfMeans = meanSum/num;
     return meanOfMeans;
    }
 
 
//Code below is for method used for Parts 1 and 2, question C.
 public static double standardD(double[] sampleMean, double variance, 
 double meanOfMeans, int power, int num){
     for(int i = 0; i < sampleMean.length; i++){
     variance += Math.pow(sampleMean[i]-meanOfMeans, power);
    }variance /= num;
//Next line takes the square root of the variance to get the std.
     double standardD = Math.sqrt(variance);
     return standardD;
    }
 
 
/*Main Method*/
 public static void main(String[] args) {
//Begin majority variable declaration and initialization in main method.
                double[] sampleMean1 = new double[400];
                double[] x = new double[225];
                int[] set = {10,20,30,40,50,60};
                double[] meanSum = new double[2];
                double[] meanOfMeans = new double[2];
                double[] count = new double[2];
                double[] probability = new double[2];
                double[] variance = new double[2];
                double[] standardD = new double[2];
                double[] sampleMean2 = new double[1600];
                int[] y = new int[324];
//End majority of variable declaration and initialization.  
                
    System.out.println("Part 1: Printing mean of each of the 400 samples");
//Code below Invokes sampleMean method to create a list of the random means.
    sampleMean(sampleMean1, x, 0, 10, 2, 225);
    System.out.println("\nPart 2: Printing mean of each of the 1600 samples");
//Code below Invokes sampleMean method to generate numbers for part 2.
    sampleMean(sampleMean2, y, set, 0, 0, 5, 324);
//Next few lines find the probability for part 1, question A.
    for(int i = 0; i < sampleMean1.length; i++){
        if(sampleMean1[i] >= 10.4 && sampleMean1[i] <= 11.1){       
            count[0]++;
        }
    }probability[0] = count[0]/400;
    
//Next few lines find the probability for part 2, question A.
    for(int i=0; i < sampleMean2.length; i++){
        if(sampleMean2[i] < 34.5 && sampleMean2[i] > 29.5){
            count[1]++;
        }
    }probability[1] = count[1]/1600;
//Next line invokes meanOfMeans method in order to retrieve meanOfMeans1.
    meanOfMeans[0] = meanOfMeans(sampleMean1, meanSum[0], 400);
//Next line invokes meanOfMeans method in order to retrieve meanOfMeans2.
    meanOfMeans[1] = meanOfMeans(sampleMean2, meanSum[1], 1600);
//Next Line invokes standardD method to find standard deviation for part 1.
    standardD[0] = standardD(sampleMean1, variance[0], meanOfMeans[0], 2, 400);
//Next Line invokes standard D method to find standard deviation for part 2.
    standardD[1] = standardD(sampleMean2, variance[1], meanOfMeans[1], 2, 1600);

//Below is the code for outputing all answers.
  System.out.println("\nSimulation complete, here are the results:\n\n"
  + "Part 1 answers:");
  System.out.println("A) Probability that mean is between 10.4 and 11.1 "
  + "inclusive: "+
  m.format(probability[0]));
  System.out.println("B) Mean of Means: "+m.format(meanOfMeans[0]));
  System.out.println("C) Standard Deviation of Means: "+m.format(standardD[0]));
  System.out.println("\nPart 2 answers:");
  System.out.println("A) Probability that mean is between 29.5 and "
  + "34.5 exclusive: "+m.format(probability[1]));
  System.out.println("B) Mean of Means: "+m.format(meanOfMeans[1]));
  System.out.println("C) Standard Deviation of Means: "+m.format(standardD[1]));
    }
    
}
