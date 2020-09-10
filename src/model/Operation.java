package model;
import ui.Main;
import java.util.*;


public class Operation { 


 public static final double DESIGN_STAGE = 1300000;
 public static final double POST_CONSTRUCTION = 2600000;
 public static final double PAINT = 980000;


	public double bestPrice(double a, double b, double c){

		double lowest = 0;;

			if (b < a && b < c){

				lowest = b;

			}

			if (c < a && c < b){

				lowest = c;
			}


			if (a < b && a < c){

				lowest = a;

			}

		return lowest;



		}


	public String bestPlace(double a, double b, double c){

		double lowest = 0;;

			if (b < a && b < c){

				lowest = b;

			}

			if (c < a && c < b){

				lowest = c;
			}


			if (a < b && a < c){

				lowest = a;

			}

		return lowest;



		}




}
