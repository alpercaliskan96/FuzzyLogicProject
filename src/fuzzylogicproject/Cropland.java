package fuzzylogicproject;

import net.sourceforge.jFuzzyLogic.FIS;

import java.io.File;
import java.net.URISyntaxException;

public class Cropland {
    private FIS fis;
    private double amountOfWater;
    private double amountOfWheatSeed;
    private double amountOfSunnyHours;

    public Cropland(double amountOfWater, double amountOfWheatSeed, double amountOfSunnyHours)throws URISyntaxException {
        this.amountOfWater = amountOfWater;
        this.amountOfWheatSeed = amountOfWheatSeed;
        this.amountOfSunnyHours = amountOfSunnyHours;
         
        File file = new File(getClass().getResource("FuzzyModel.fcl").toURI());
        fis = FIS.load(file.getPath(), true);
 
        fis.setVariable("amountOfWater", amountOfWater);
        fis.setVariable("amountOfWheatSeed", amountOfWheatSeed);
        fis.setVariable("amountOfSunnyHours", amountOfSunnyHours);
        fis.evaluate();
        System.out.println("Resulting Wheat : " + fis.getVariable("resultingWheat").getValue());
    }

     public FIS getFis(){ return this.fis; }
     
     public Cropland() throws URISyntaxException{
         File file = new File(getClass().getResource("FuzzyModel.fcl").toURI());
         fis = FIS.load(file.getPath(), true);
     }
     
     @Override
     public String toString(){
         return "Amount of water" + amountOfWater + "\n Amount of Wheat" + amountOfWheatSeed + "\n Amount of Sunny Hours" + amountOfSunnyHours +
                 "\n Resulting Wheat" + fis.getVariable("resultingWheat").getValue();
     }
     
     public double amountOfWater() { return amountOfWater; }
     
     public double amountOfWheatSeed() {
         return amountOfWheatSeed;
     }

     public double amountOfSunnyHours() {
         return amountOfSunnyHours;
     }
}