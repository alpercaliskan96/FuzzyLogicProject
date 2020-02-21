package fuzzylogicproject;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import java.net.URISyntaxException;
import java.util.Scanner;

public class FuzzyLogicProject {

    public static void main(String[] args) throws URISyntaxException{
        Scanner in = new Scanner(System.in);
        
        System.out.println("Amount of water : ");
        double amountOfWater = in.nextDouble();
        
        System.out.println("Amount of wheat seed  : ");
        double amountOfWheatSeed = in.nextDouble();
        
        System.out.println("Amount of sunny hours(About 10 months * 24 hours): ");
        double amountOfSunnyHours = in.nextDouble();

        Cropland cropland = new Cropland(amountOfWater, amountOfWheatSeed, amountOfSunnyHours);  
        JFuzzyChart.get().chart(cropland.getFis());
        
        for(Rule r : cropland.getFis().getFunctionBlock("fuzzyModel").getFuzzyRuleBlock("ruleBlock1")){
            if(r.getDegreeOfSupport() > 0) {
                System.out.println(r);
            }
        }
    } 
}